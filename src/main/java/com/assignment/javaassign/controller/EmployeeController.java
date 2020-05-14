package com.assignment.javaassign.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.javaassign.model.Employee;
import com.assignment.javaassign.repo.EmployeeRepository;
import com.assignment.javaassign.response.MessageResponse;

/**
 * @author DGOTI
 *
 */
@RestController
@RequestMapping("/Employee")
public class EmployeeController {
	
	@Autowired
	private EmployeeRepository repository;
	
	/**
	 * @param id
	 * @return
	 */
	@RequestMapping(path="/get/{id}",  method = RequestMethod.GET)
	public ResponseEntity<?> getEmp(@PathVariable Long id) {
		Employee emp = repository.findById(id).orElse(null);
		if(emp == null) 
			return new ResponseEntity<MessageResponse>(new MessageResponse("Employee not found with id - "+id+"."), HttpStatus.NOT_FOUND);
		else
			return new ResponseEntity<Employee>(emp, HttpStatus.OK);
	}
	
	/**
	 * @param emp
	 * @return
	 */
	@RequestMapping(path="/save",  method = RequestMethod.POST)
	public Employee saveEmp(@RequestBody Employee emp) {
		System.out.println(" Save Employee");
		return repository.save(emp);
	}
	
	/**
	 * @param emp
	 * @return
	 */
	@RequestMapping(path="/update",  method = RequestMethod.POST)
	public Employee updateEmp(@RequestBody Employee emp) {
		return repository.save(emp);
	}

	/**
	 * @param id
	 * @return
	 */
	
	@RequestMapping(path="/delete/{id}",  method = RequestMethod.DELETE)
	public ResponseEntity<MessageResponse> deleteEmp(@PathVariable Long id) {
		repository.deleteById(id);
		return new ResponseEntity<MessageResponse>(new MessageResponse("Employee deleted successfully."), HttpStatus.OK);
	}
}
