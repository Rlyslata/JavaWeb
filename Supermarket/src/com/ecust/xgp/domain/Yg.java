package com.ecust.xgp.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the yg database table.
 * 
 */
@Entity
@NamedQuery(name="Yg.findAll", query="SELECT y FROM Yg y")
public class Yg implements Serializable {
	private static final long serialVersionUID = 1L;

	private Date attendDate;
	
	private Date birth;
	
	@Id
	private String employeeId;

	private String employeeName;

	private String employeePassword;

	private int salary;

	public Yg() {
	}

	public Yg(String employeeId,  String employeePassword,String employeeName,Date attendDate, Date birth,  
			int salary) {
		super();
		this.attendDate = attendDate;
		this.birth = birth;
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.employeePassword = employeePassword;
		this.salary = salary;
	}

	public Date getAttendDate() {
		return this.attendDate;
	}

	public void setAttendDate(Date attendDate) {
		this.attendDate = attendDate;
	}

	public Date getBirth() {
		return this.birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	public String getEmployeeId() {
		return this.employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return this.employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getEmployeePassword() {
		return this.employeePassword;
	}

	public void setEmployeePassword(String employeePassword) {
		this.employeePassword = employeePassword;
	}

	public int getSalary() {
		return this.salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

}