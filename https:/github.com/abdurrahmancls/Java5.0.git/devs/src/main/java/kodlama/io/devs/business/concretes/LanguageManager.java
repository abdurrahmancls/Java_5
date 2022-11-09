package kodlama.io.devs.business.concretes;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.devs.business.abstracts.LanguageService;
import kodlama.io.devs.business.requests.language.CreateLanguageRequest;
import kodlama.io.devs.business.requests.language.DeleteLanguageRequest;
import kodlama.io.devs.business.requests.language.UpdateLanguageRequest;
import kodlama.io.devs.business.responses.GetAllLanguageResponse;
import kodlama.io.devs.dataAcces.abstracts.LanguageRepository;
import kodlama.io.devs.entities.concretes.Language;

@Service
public class LanguageManager implements LanguageService{
	private LanguageRepository languageRepository;

	@Autowired
	public LanguageManager(LanguageRepository languageRepository) {
		this.languageRepository = languageRepository;
	}
	
	@Override
	public List<GetAllLanguageResponse> getAll() {
		List<Language> languages=languageRepository.findAll();
		List<GetAllLanguageResponse> languageResponse =new ArrayList<GetAllLanguageResponse>();
		
		for (Language language : languages) {
			GetAllLanguageResponse responseItem=new GetAllLanguageResponse();
			responseItem.setId(language.getId());
			responseItem.setName(language.getName());
			languageResponse.add(responseItem);
		}
		
		return languageResponse ;
	}

	@Override
	public void add(CreateLanguageRequest createlanguagerequest) throws Exception {
		Language language=new Language();
		List<Language> languages= languageRepository.findAll();
		if(createlanguagerequest == null) {
			throw new Exception("Dil boş olmaz!");
		}else {
			for(Language lang: languages) {
				if(createlanguagerequest.getName() == lang.getName())
					throw new Exception("Diller aynı olamaz!");
			}
			language.setName(createlanguagerequest.getName());
			languageRepository.save(language);
		}
		
	}

	@Override
	public void delete(DeleteLanguageRequest deletelenguagerequest) {
		Language language=GetById(deletelenguagerequest.getId());
		languageRepository.delete(language);
		
	}


	@Override
	public void update(UpdateLanguageRequest updatelanguagerequest) {
		Language language=GetById(updatelanguagerequest.getId());
		language.setName(updatelanguagerequest.getName());
		
	}

	@Override
	public Language GetById(int id) {
		List<Language> languages=languageRepository.findAll();
		for(Language language: languages) {
			if(language.getId() == id)
				return language;
		}
		return null;
	}
	

}
