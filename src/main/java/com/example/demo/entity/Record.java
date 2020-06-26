package com.example.demo.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "RECORDS")
public class Record {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "id")
	@Column(name = "ID" , nullable = false)
	private int id;
	@Column(name = "TYPE" , nullable = false)
	private Boolean type;
	@Column(name = "REASON" , nullable = false)
	private String reason;
	@Column(name = "DATE" , nullable = false)
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "MM/dd/yyyy")
	private Date date;
	@ManyToOne
	@JoinColumn(name = "STAFFID")
	private Staff staff;
	
	public Record() {
		// TODO Auto-generated constructor stub
	}

	public Record(int id, Boolean type, String reason, Date date, Staff staff) {
		super();
		this.id = id;
		this.type = type;
		this.reason = reason;
		this.date = date;
		this.staff = staff;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Boolean getType() {
		return type;
	}

	public void setType(Boolean type) {
		this.type = type;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Staff getStaff() {
		return staff;
	}

	public void setStaff(Staff staff) {
		this.staff = staff;
	}
	
}
