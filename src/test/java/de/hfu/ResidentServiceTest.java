package de.hfu;
import java.util.Date;
import org.junit.Test;
import de.hfu.residents.domain.Resident;
import de.hfu.residents.repository.ResidentRepository;
import de.hfu.residents.repository.ResidentRepositoryStub;
import de.hfu.residents.service.*;

public class ResidentServiceTest {
	@Test
	public void testGetUniqueResident() throws ResidentServiceException {
		Resident resident1 = new Resident("Mark", "Weber", "Stuttgarter Straße 1", "Tübingen", new Date());
		Resident resident2 = new Resident("Sarah", "Schneider", "Basler Straße 2", "Freiburg", new Date());
		Resident resident3 = new Resident("Vinicius", "Costa", "Vinicius Straße 3", "ViniciusStadt", new Date());
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
	}
}