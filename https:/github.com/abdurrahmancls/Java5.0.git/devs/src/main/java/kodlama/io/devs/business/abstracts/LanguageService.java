package kodlama.io.devs.business.abstracts;

import java.util.List;

import kodlama.io.devs.business.requests.language.CreateLanguageRequest;
import kodlama.io.devs.business.requests.language.DeleteLanguageRequest;
import kodlama.io.devs.business.requests.language.UpdateLanguageRequest;
import kodlama.io.devs.business.responses.GetAllLanguageResponse;
import kodlama.io.devs.entities.concretes.Language;


public interface LanguageService  {
	
	void add(CreateLanguageRequest language) throws Exception;
	void delete(DeleteLanguageRequest language);
	void update(UpdateLanguageRequest language);
	
	List<GetAllLanguageResponse> getAll();
	Language GetById(int id);
	

}
