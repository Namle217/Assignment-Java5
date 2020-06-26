package com.example.demo.entity;

import java.util.Collection;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table( name = "Staffs")
public class Staff {
	@Id
	@Column(name = "ID",nullable = false )
	private String id;
	@OneToMany( mappedBy = "staff", fetch = FetchType.EAGER,cascade = CascadeType.REMOVE)
	private Collection<Record> record;
	@Column(name = "NAME",nullable = false )
	private String name;
	
	@Column(name = "GENDER",nullable = false )
	private Boolean gender;
	
	@Column(name = "BIRTHDAY",nullable = false )
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "MM/dd/yyyy")
	private Date birthday;
	
	@Column(name = "PHOTO",nullable = false )
	private String photo;
	
	@Column(name = "EMAIL",nullable = false )
	private String email;
	
	@Column(name = "PHONE",nullable = false )
	private String phone;
	
	@Column(name = "SALARY",nullable = false )
	private Double salary;
	
	
	@ManyToOne
	@JoinColumn(name = "DEPARTID")
	private Depart depart;
	public Staff() {
		// TODO Auto-generated constructor stub
	}

	public Staff(String id, Collection<Record> record, String name, Boolean gender, Date birthday, String photo,
			String email, String phone, Double salary, Depart depart) {
		super();
		this.id = id;
		this.record = record;
		this.name = name;
		this.gender = gender;
		this.birthday = birthday;
		this.photo = photo;
		this.email = email;
		this.phone = phone;
		this.salary = salary;
		this.depart = depart;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public Collection<Record> getRecord() {
		return record;
	}


	public void setRecord(Collection<Record> record) {
		this.record = record;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Boolean getGender() {
		return gender;
	}


	public void setGender(Boolean gender) {
		this.gender = gender;
	}


	public Date getBirthday() {
		return birthday;
	}


	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}


	public String getPhoto() {
		return photo;
	}


	public void setPhoto(String photo) {
		this.photo = photo;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public Double getSalary() {
		return salary;
	}


	public void setSalary(Double salary) {
		this.salary = salary;
	}


	public Depart getDepart() {
		return depart;
	}


	public void setDepart(Depart depart) {
		this.depart = depart;
	}
}
