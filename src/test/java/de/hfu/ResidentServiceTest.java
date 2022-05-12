package de.hfu;
import java.util.Date;
import org.junit.Test;
import de.hfu.residents.domain.Resident;
import de.hfu.residents.repository.ResidentRepository;
import de.hfu.residents.repository.ResidentRepositoryStub;
import de.hfu.residents.service.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class ResidentServiceTest {
	@Test
	public void testGetUniqueResident() throws ResidentServiceException {
		Resident resident1 = new Resident("Mark", "Weber", "Stuttgarter Straße 1", "Tübingen", new Date());
		Resident resident2 = new Resident("Sarah", "Schneider", "Basler Straße 2", "Freiburg", new Date());
		Resident resident3 = new Resident("Vinicius", "Costa", "Vinicius Straße 3", "Furtwangen", new Date());
		ResidentRepository stub = new ResidentRepositoryStub();
		stub.getResidents().add(resident1);
		stub.getResidents().add(resident2);
		stub.getResidents().add(resident3);
		BaseResidentService service = new BaseResidentService();
		service.setResidentRepository(stub);
		service.getFilteredResidentsList(resident1);
		service.getUniqueResident(resident1);
		service.getFilteredResidentsList(resident2);
		service.getUniqueResident(resident2);
		service.getFilteredResidentsList(resident3);
		service.getUniqueResident(resident3);
		
		assertThat(resident1.getFamilyName(),is(equalTo("Weber")));
		assertThat(resident1.getCity(),is(equalTo("Tübingen")));
		assertThat(resident1.getStreet(),is(equalTo("Stuttgarter Straße 1")));
		assertThat(resident2.getGivenName(),is(equalTo("Sarah")));
		assertThat(resident2.getStreet(),is(equalTo("Basler Straße 2")));
		assertThat(resident2.getCity(),is(equalTo("Freiburg")));
		assertThat(resident3.getFamilyName(),is(equalTo("Costa")));
		assertThat(resident3.getGivenName(),is(equalTo("Vinicius")));
		assertThat(resident3.getCity(),is(equalTo("Furtwangen")));
	}
}