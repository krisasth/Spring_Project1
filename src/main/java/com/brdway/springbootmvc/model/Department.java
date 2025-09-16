package com.brdway.springbootmvc.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="department_table")
public class Department {
 
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int deptid;
	private String name;
	private String deptphone;
	private String depthead;
	public int getDeptid() {
		return deptid;
	}
	public void setDeptid(int deptid) {
		this.deptid = deptid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDeptphone() {
		return deptphone;
	}
	public void setDeptphone(String deptphone) {
		this.deptphone = deptphone;
	}
	public String getDepthead() {
		return depthead;
	}
	public void setDepthead(String depthead) {
		this.depthead = depthead;
	}
	
}
