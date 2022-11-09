package kodlama.io.devs.webApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.devs.business.abstracts.LanguageService;
import kodlama.io.devs.business.requests.language.CreateLanguageRequest;
import kodlama.io.devs.business.requests.language.DeleteLanguageRequest;
import kodlama.io.devs.business.requests.language.UpdateLanguageRequest;
import kodlama.io.devs.business.responses.GetAllLanguageResponse;
import kodlama.io.devs.entities.concretes.Language;

@RestController
@RequestMapping("/api/languages")

public class LanguageController {
	private  LanguageService languageService;

	@Autowired
	public LanguageController(LanguageService languageService) {
		this.languageService = languageService;
	}
	
	@GetMapping("/getall")
	public List<GetAllLanguageResponse> getAll(){
		return languageService.getAll();
	}
	@GetMapping("/getwithid/{id}")
	public Language GetById(int id) {
		return languageService.GetById(id);
		
	}
	 @PostMapping("/add")
	    public void add(CreateLanguageRequest createLanguageRequest){
	        try {
				this.languageService.add(createLanguageRequest);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
	    }
	
	@DeleteMapping("/delete/{id}")
    public void delete(DeleteLanguageRequest deleteLanguageRequest){
        this.languageService.delete(deleteLanguageRequest);
    }
	 @PutMapping("/update/{id}")
	    public void update(UpdateLanguageRequest updateLanguageRequest){
	        this.languageService.update(updateLanguageRequest);
	    }

}
