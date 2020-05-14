package com.assignment.javaassign.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.javaassign.model.Hobby;
import com.assignment.javaassign.repo.HobbyRepository;
import com.assignment.javaassign.response.MessageResponse;

@RestController
@RequestMapping("/hobby")
public class HobbyController {
	
	@Autowired
	private HobbyRepository repository;
	
	/**
	 * @param id
	 * @return
	 */
	@RequestMapping(path="/get/{id}",  method = RequestMethod.GET)
	public ResponseEntity<?> getHobby(@PathVariable Long id) {
		Hobby hobby = repository.findById(id).orElse(null);
		if(hobby == null) 
			return new ResponseEntity<MessageResponse>(new MessageResponse("Hobby not found with id - "+id+"."), HttpStatus.NOT_FOUND);
		else
			return new ResponseEntity<Hobby>(hobby, HttpStatus.OK);
	}
	
	/**
	 * @param id
	 * @return
	 */
	@RequestMapping(path="/getAll",  method = RequestMethod.GET)
	public ResponseEntity<?> getAllHobby(@PathVariable Long id) {
		List<Hobby> hobby = repository.findAll();
		
		return new ResponseEntity<List<Hobby>>(hobby, HttpStatus.OK);
	}
	
	
	/**
	 * @param emp
	 * @return
	 */
	@RequestMapping(path="/save",  method = RequestMethod.POST)
	public Hobby saveEmp(@RequestBody Hobby hobby) {
		System.out.println(" Save hobby");
		return repository.save(hobby);
	}
	
	/**
	 * @param emp
	 * @return
	 */
	@RequestMapping(path="/update",  method = RequestMethod.POST)
	public Hobby updateEmp(@RequestBody Hobby hobby) {
		return repository.save(hobby);
	}

	/**
	 * @param id
	 * @return
	 */
	
	@RequestMapping(path="/delete/{id}",  method = RequestMethod.DELETE)
	public ResponseEntity<MessageResponse> deleteHobby(@PathVariable Long id) {
		repository.deleteById(id);
		return new ResponseEntity<MessageResponse>(new MessageResponse("Hobby deleted successfully."), HttpStatus.OK);
	}
}
