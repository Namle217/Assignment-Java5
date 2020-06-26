package com.example.demo.entity;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table( name = "Departs")
public class Depart {
	@Id
	@Column(name = "ID", nullable = false)
	private String id;
	@OneToMany( mappedBy = "depart", fetch = FetchType.EAGER,cascade = CascadeType.REMOVE)
	private Collection<Staff> staffs;
	@Column(name = "NAME", nullable = false)
	private String name;
	
	public Depart() {
		// TODO Auto-generated constructor stub
	}
	
	public Depart(String id, Collection<Staff> staffs, String name) {
		super();
		this.id = id;
		this.staffs = staffs;
		this.name = name;
	}

	
	public String getId() {
		return id;
	}



	public void setId(String id) {
		this.id = id;
	}



	public Collection<Staff> getStaffs() {
		return staffs;
	}



	public void setStaffs(Collection<Staff> staffs) {
		this.staffs = staffs;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}	
	
}
