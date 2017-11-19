package com.dotridge.bean;

import java.io.Serializable;

public class AdminBean implements Serializable {

	private static final long serialVersionUID = 6083941016563604131L;

	private int adminId;
	private String firstName;
	private String middleName;
	private String lastName;
	private String phone;
	private String email;
	private String password;
	private String profileDocument;
	private String hospitalName;
	private String status;

	public int getAdminId() {
		return adminId;
	}

	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getProfileDocument() {
		return profileDocument;
	}

	public void setProfileDocument(String profileDocument) {
		this.profileDocument = profileDocument;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getHospitalName() {
		return hospitalName;
	}

	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}

	@Override
	public String toString() {
		return "AdminBean [adminId=" + adminId + ", firstName=" + firstName + ", middleName=" + middleName
				+ ", lastName=" + lastName + ", phone=" + phone + ", email=" + email + ", password=" + password
				+ ", profileDocument=" + profileDocument + ", hospitalName=" + hospitalName + ", status=" + status
				+ "]";
	}

}
