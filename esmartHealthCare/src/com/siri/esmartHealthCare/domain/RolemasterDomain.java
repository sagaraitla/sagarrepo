package com.siri.esmartHealthCare.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name ="AROLEMASTER")
public class RolemasterDomain {
	

	@Id
	@GeneratedValue
	@Column(name = "ROLEID")
	private Integer roleId;
	@Column(name = "ROLENAME")
	private String roleName;
	
	@OneToMany(cascade=CascadeType.ALL)
	private List<DepartmentDomine> dept;
	
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
	public List<DepartmentDomine> getDept() {
		return dept;
	}
	public void setDept(List<DepartmentDomine> dept) {
		this.dept = dept;
	}
	
	
	
	
	

}
