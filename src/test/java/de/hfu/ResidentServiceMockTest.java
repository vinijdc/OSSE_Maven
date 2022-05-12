package de.hfu;

import java.util.Date;
import java.util.List;

import org.junit.Before;
import de.hfu.residents.domain.Resident;
import de.hfu.residents.repository.ResidentRepositoryStub;
import de.hfu.residents.service.*;
import static org.junit.Assert.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class ResidentServiceMockTest {
	private ResidentRepositoryStub testResidentRepository;
	private BaseResidentService testBaseResidentService;
	Resident resident1;
	Resident resident2;
	Resident resident3;
	Resident resident4;
	Resident resident5;
	
	@Before
	public void testGetUniqueResident1() throws Exception {
		testResidentRepository = new ResidentRepositoryStub();
		testBaseResidentService = new BaseResidentService();
		testBaseResidentService.setResidentRepository(testResidentRepository);
		resident1 = new Resident("Mark", "Weber", "Stuttgarter Straße 1", "Tübingen", new Date());
		resident2 = new Resident("Sarah", "Schneider", "Basler Straße 2", "Freiburg", new Date());
		resident3 = new Resident("Vinicius", "Costa", "Vinicius Straße 3", "Furtwangen", new Date());
		resident4 = new Resident("Carlos", "Mustermann", "Musterstraße 25", "Furtwangen", new Date());
		resident5 = new Resident("Claudia", "Musterfrau", "Musterstraße 7", "Furtwangen", new Date());
		testResidentRepository.addResident(resident1);
		testResidentRepository.addResident(resident2);
		testResidentRepository.addResident(resident3);
		testResidentRepository.addResident(resident4);
		testResidentRepository.addResident(resident5);
		
	}
	
	public void getFilteredResidentsListTest1() {
		Resident filter = new Resident("Mark", "", "", "", new Date());
		List<Resident> result = testBaseResidentService.getFilteredResidentsList(filter);
		
		assertTrue(result.contains(resident1));
		assertFalse(result.contains(resident2));
		assertFalse(result.contains(resident3));
		assertFalse(result.contains(resident4));
		assertFalse(result.contains(resident5));
	}
	
	public void getFilteredResidentsListTest2() {
		Resident filter = new Resident("","Schneider","","", new Date());
		List<Resident> result = testBaseResidentService.getFilteredResidentsList(filter);
		
		assertFalse(result.contains(resident1));
		assertTrue(result.contains(resident2));
		assertFalse(result.contains(resident3));
		assertFalse(result.contains(resident4));
		assertFalse(result.contains(resident5));
	}
	
	public void getFilteredResidentsListTest3() {
		Resident filter = new Resident("","Muster*","","", new Date());
		List<Resident> result = testBaseResidentService.getFilteredResidentsList(filter);
		
		assertFalse(result.contains(resident1));
		assertFalse(result.contains(resident2));
		assertFalse(result.contains(resident3));
		assertTrue(result.contains(resident4));
		assertTrue(result.contains(resident5));
	}
	
	public void getUniqueResidentTest1() throws ResidentServiceException {
		Resident filter = new Resident("","", "Basler Straße 2", "", new Date());
		Resident result = testBaseResidentService.getUniqueResident(filter);
		
		assertThat(result.getStreet(), is(equalTo(resident2.getStreet())));
	}
	
	public void getUniqueResidentTest2() throws ResidentServiceException {
		Resident filter = new Resident("","","","Furtwangen", new Date());
		Resident result = testBaseResidentService.getUniqueResident(filter);
		
		assertThat(result.getCity(), is(equalTo(resident3.getCity())));
		assertThat(result.getCity(), is(equalTo(resident4.getCity())));
		assertThat(result.getCity(), is(equalTo(resident5.getCity())));
	}
	
	public void getUniqueResidentTest3() throws ResidentServiceException {
		Resident filter = new Resident("","Muster*","","", new Date());
		Resident result = testBaseResidentService.getUniqueResident(filter);
		
		assertFalse(result.equals(resident1));
		assertFalse(result.equals(resident2));
		assertFalse(result.equals(resident3));
		assertFalse(result.equals(resident4));
		assertFalse(result.equals(resident5));
	}
}