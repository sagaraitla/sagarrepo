package com.dotridge.bean;

import java.io.Serializable;
//created by User:sagar
public class HospitalBean implements Serializable {

	private static final long serialVersionUID = 157245513233829157L;

	private int hospitalId;
	private String hospitalName;
	private String address1;
	private String address2;
	private String city;
	private String state;
	private String zipcode;
	private String email;
	private String phone;
	private String fax;
	private String file;
	private String status;

	public int getHospitalId() {
		return hospitalId;
	}

	public void setHospitalId(int hospitalId) {
		this.hospitalId = hospitalId;
	}

	public String getHospitalName() {
		return hospitalName;
	}

	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
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

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
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

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getFile() {
		return file;
	}

	public void setFile(String file) {
		this.file = file;
	}

	public String getStatus() {
		return status;
	}

	@Override
	public String toString() {
		return "HospitalBean [hospitalId=" + hospitalId + ", hospitalName=" + hospitalName + ", address1=" + address1
				+ ", address2=" + address2 + ", city=" + city + ", state=" + state + ", zipcode=" + zipcode + ", email="
				+ email + ", phone=" + phone + ", fax=" + fax + ", file=" + file + ", status=" + status + "]";
	}

	public void setStatus(String status) {
		this.status = status;
	}

	

}
