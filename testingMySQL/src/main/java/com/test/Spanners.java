package com.test;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Spanners {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id ;
	private String name ;
	private int size ;
	private String owner ;
	
	@OneToOne(cascade = {CascadeType.ALL})
	private Helper helper ;
	
	public Helper getHelper() {
		return helper;
	}
	public void setHelper(Helper helper) {
		this.helper = helper;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	
	

}
