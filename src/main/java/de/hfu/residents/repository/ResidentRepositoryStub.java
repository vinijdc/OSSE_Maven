package de.hfu.residents.repository;
import java.util.ArrayList;
import java.util.List;
import de.hfu.residents.domain.Resident;

public class ResidentRepositoryStub implements ResidentRepository{
	
	private List<Resident> residents = new ArrayList<>();

	@Override
	public List<Resident> getResidents() {
		return residents;
	}
	
	public void addResident(Resident resident) {
		residents.add(resident);
	}
}