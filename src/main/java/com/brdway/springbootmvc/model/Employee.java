package com.brdway.springbootmvc.model;

import java.time.LocalDate;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import jakarta.persistence.CascadeType;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
@Entity
@Table(name="emp_tbl")
public class Employee {
	@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private Long id;
private String fname;
private String lname;
private String gender;
private String phone;
@DateTimeFormat(iso= ISO.DATE)
private LocalDate dob;
private String email;
private String company;
private String post;
private int salary;
@DateTimeFormat(iso= ISO.DATE)
private LocalDate Joindate;
@ManyToMany
private List<Department> departments;

@OneToOne(cascade = CascadeType.ALL)
@JoinColumn(name="adrId")
private Address address;

@ElementCollection
@CollectionTable
private List<String> projects;
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public String getFname() {
	return fname;
}
public void setFname(String fname) {
	this.fname = fname;
}
public String getLname() {
	return lname;
}
public void setLname(String lname) {
	this.lname = lname;
}
public String getGender() {
	return gender;
}
public void setGender(String gender) {
	this.gender = gender;
}
public String getPhone() {
	return phone;
}
public void setPhone(String phone) {
	this.phone = phone;
}
public LocalDate getDob() {
	return dob;
}
public void setDob(LocalDate dob) {
	this.dob = dob;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getCompany() {
	return company;
}
public void setCompany(String company) {
	this.company = company;
}
public String getPost() {
	return post;
}
public void setPost(String post) {
	this.post = post;
}
public int getSalary() {
	return salary;
}
public void setSalary(int salary) {
	this.salary = salary;
}
public LocalDate getJoindate() {
	return Joindate;
}
public void setJoindate(LocalDate joindate) {
	Joindate = joindate;
}
public List<Department> getDepartments() {
	return departments;
}
public void setDepartments(List<Department> departments) {
	this.departments = departments;
}
public Address getAddress() {
	return address;
}
public void setAddress(Address address) {
	this.address = address;
}
public List<String> getProjects() {
	return projects;
}
public void setProjects(List<String> projects) {
	this.projects = projects;
}

}
