package com.dotridge.domain;

import java.io.File;
import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import org.hibernate.annotations.Type;

import com.dotridge.util.BooleanToStringConverter;

@Entity
public class Hospital implements Serializable,Cloneable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4365720373839147515L;

	@javax.persistence.Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int Id;
	@Column(nullable=false,unique=true)
	private String hospitalName;
	private String address1;
	private String address2;
	private String city;
	private String state;
	private long zipCode;
	private String email;
	private long phone;
	private String fax;
	@Column
	private File logo;
	private File requiredDocument;
 	private String createdBy;
	private Date createdDate;
	private String modifiedBy;
	private Date modifiedDate;
	/*@Column
	@Convert(converter=BooleanToStringConverter.class)
	private Boolean status;*/
	@Column
	private String status="Inactive";
	
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
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
	public long getZipCode() {
		return zipCode;
	}
	public void setZipCode(long zipCode) {
		this.zipCode = zipCode;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	public String getFax() {
		return fax;
	}
	public void setFax(String fax) {
		this.fax = fax;
	}
	public File getLogo() {
		return logo;
	}
	public void setLogo(File logo) {
		this.logo = logo;
	}
	public File getRequiredDocument() {
		return requiredDocument;
	}
	public void setRequiredDocument(File requiredDocument) {
		this.requiredDocument = requiredDocument;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public String getModifiedBy() {
		return modifiedBy;
	}
	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}
	public Date getModifiedDate() {
		return modifiedDate;
	}
	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Id;
		result = prime * result + ((address1 == null) ? 0 : address1.hashCode());
		result = prime * result + ((address2 == null) ? 0 : address2.hashCode());
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((createdBy == null) ? 0 : createdBy.hashCode());
		result = prime * result + ((createdDate == null) ? 0 : createdDate.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((fax == null) ? 0 : fax.hashCode());
		result = prime * result + ((hospitalName == null) ? 0 : hospitalName.hashCode());
		result = prime * result + ((logo == null) ? 0 : logo.hashCode());
		result = prime * result + ((modifiedBy == null) ? 0 : modifiedBy.hashCode());
		result = prime * result + ((modifiedDate == null) ? 0 : modifiedDate.hashCode());
		result = prime * result + (int) (phone ^ (phone >>> 32));
		result = prime * result + ((requiredDocument == null) ? 0 : requiredDocument.hashCode());
		result = prime * result + ((state == null) ? 0 : state.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + (int) (zipCode ^ (zipCode >>> 32));
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Hospital other = (Hospital) obj;
		if (Id != other.Id)
			return false;
		if (address1 == null) {
			if (other.address1 != null)
				return false;
		} else if (!address1.equals(other.address1))
			return false;
		if (address2 == null) {
			if (other.address2 != null)
				return false;
		} else if (!address2.equals(other.address2))
			return false;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (createdBy == null) {
			if (other.createdBy != null)
				return false;
		} else if (!createdBy.equals(other.createdBy))
			return false;
		if (createdDate == null) {
			if (other.createdDate != null)
				return false;
		} else if (!createdDate.equals(other.createdDate))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (fax == null) {
			if (other.fax != null)
				return false;
		} else if (!fax.equals(other.fax))
			return false;
		if (hospitalName == null) {
			if (other.hospitalName != null)
				return false;
		} else if (!hospitalName.equals(other.hospitalName))
			return false;
		if (logo == null) {
			if (other.logo != null)
				return false;
		} else if (!logo.equals(other.logo))
			return false;
		if (modifiedBy == null) {
			if (other.modifiedBy != null)
				return false;
		} else if (!modifiedBy.equals(other.modifiedBy))
			return false;
		if (modifiedDate == null) {
			if (other.modifiedDate != null)
				return false;
		} else if (!modifiedDate.equals(other.modifiedDate))
			return false;
		if (phone != other.phone)
			return false;
		if (requiredDocument == null) {
			if (other.requiredDocument != null)
				return false;
		} else if (!requiredDocument.equals(other.requiredDocument))
			return false;
		if (state == null) {
			if (other.state != null)
				return false;
		} else if (!state.equals(other.state))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (zipCode != other.zipCode)
			return false;
		return true;
	}
	@Override
	public Object clone() {
		
		try {
			return super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return Id;
	}
	
	
	
/*	@Override
	public Object clone(){  
		Hospital hospital = new Hospital();
		hospital.setId(this.Id);
		hospital.setHospitalName(this.hospitalName);
		hospital.setAddress1(this.address1);;
		hospital.setAddress2(this.address2);
		hospital.setCity(this.city);
		hospital.setState(this.state);
		hospital.setZipCode(this.zipCode);
		hospital.setEmail(this.email);
		hospital.setFax(this.fax);
		hospital.setStatus(this.status);
		hospital.setLogo(this.logo);
		hospital.setCreatedDate(this.createdDate);
		hospital.setCreatedBy(this.createdBy);
		hospital.setModifiedBy(this.modifiedBy);
		hospital.setModifiedDate(this.modifiedDate);
		hospital.setRequiredDocument(this.requiredDocument);
		
		
		return hospital;
		//return super.clone();
	}
	*/
	
	
}
