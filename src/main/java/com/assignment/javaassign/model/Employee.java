package com.assignment.javaassign.model;

import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Employee //implements Serializable
{

	/**
	 * 
	 */
	//private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String name;
	private String street;
	private String city;
	private String state;
	private int zip;
	@ManyToMany
	@JoinTable(
			  name = "emp_hobby", 
			  joinColumns = @JoinColumn(name="emp_id"),
			  inverseJoinColumns = @JoinColumn(name = "hobby_id"))
	private Set<Hobby> hobby;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public int getZip() {
		return zip;
	}
	public void setZip(int zip) {
		this.zip = zip;
	}
	public Set<Hobby> getHobby() {
		return hobby;
	}
	public void setHobby(Set<Hobby> hobby) {
		this.hobby = hobby;
	}

	
}
