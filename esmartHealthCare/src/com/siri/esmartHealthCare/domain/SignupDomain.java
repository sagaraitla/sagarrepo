/**
 * 
 */
package com.siri.esmartHealthCare.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author VENU
 *
 */
@Entity
@Table(name = "AASIGNUP")
public class SignupDomain {
	@Id
	@GeneratedValue
	private int signid;
	
	private String firstname;
	private String middlename;
	private String lastname;
	private String email;
	private String userid;
	private String password;
	private String mobilenumber;
	private String gender;
	private String department;
	private String role;
	private String acceptTerm;
	
	
	public int getSignid() {
		return signid;
	}
	public void setSignid(int signid) {
		this.signid = signid;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getMiddlename() {
		return middlename;
	}
	public void setMiddlename(String middlename) {
		this.middlename = middlename;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMobilenumber() {
		return mobilenumber;
	}
	public void setMobilenumber(String mobilenumber) {
		this.mobilenumber = mobilenumber;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	

	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getAcceptTerm() {
		return acceptTerm;
	}
	public void setAcceptTerm(String acceptTerm) {
		this.acceptTerm = acceptTerm;
	}
	

}
