package kodlama.io.devs.business.abstracts;

import java.util.List;

import kodlama.io.devs.business.requests.technology.CreateTechnologyRequest;
import kodlama.io.devs.business.requests.technology.DeleteTechnologyRequest;
import kodlama.io.devs.business.requests.technology.UpdateTechnologyRequest;
import kodlama.io.devs.business.responses.GetAllTechnologiesResponse;
import kodlama.io.devs.entities.concretes.Technology;

public interface TechnologyService {
	void add(CreateTechnologyRequest technology);
	void delete(DeleteTechnologyRequest technology);
	void update(UpdateTechnologyRequest technology);
	List<GetAllTechnologiesResponse> getAll();
	Technology GetById(int id);

}
