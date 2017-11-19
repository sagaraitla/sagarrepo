package com.siri.esmartHealthCare.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="AROLEMASTER")
public class RolemasterBean {
	

	@Id
	@GeneratedValue
	@Column(name = "ROLEID")
	private Integer roleId;
	@Column(name = "ROLENAME")
	private String roleName;
	public Integer getRoleId() {
		return roleId;
	}
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	
	
	

}
