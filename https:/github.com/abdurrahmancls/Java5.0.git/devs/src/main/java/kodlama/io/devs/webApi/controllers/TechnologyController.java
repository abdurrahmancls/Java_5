package kodlama.io.devs.webApi.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.devs.business.abstracts.TechnologyService;
import kodlama.io.devs.business.requests.technology.CreateTechnologyRequest;
import kodlama.io.devs.business.requests.technology.DeleteTechnologyRequest;
import kodlama.io.devs.business.requests.technology.UpdateTechnologyRequest;
import kodlama.io.devs.business.responses.GetAllTechnologiesResponse;
import kodlama.io.devs.entities.concretes.Technology;

@RestController
@RequestMapping("/technology")
public class TechnologyController {
	TechnologyService techservice;
	
	@GetMapping("/getall")
	public List<GetAllTechnologiesResponse> getAll(){
		return techservice.getAll();
	}
	@GetMapping("/getwithid/{id}")
	public Technology GetById(int id) {
		return techservice.GetById(id);
	
	}
	@PostMapping("/add")
    public void add(CreateTechnologyRequest createtechrequest){
        try {
			this.techservice.add(createtechrequest);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
    }
	@DeleteMapping("/delete/{id}")
    public void delete(DeleteTechnologyRequest deletetechrequest){
        this.techservice.delete(deletetechrequest);
    }
	
	@PutMapping("/update/{id}")
    public void update(UpdateTechnologyRequest updatetechRequest){
        this.techservice.update(updatetechRequest);
    }
}
