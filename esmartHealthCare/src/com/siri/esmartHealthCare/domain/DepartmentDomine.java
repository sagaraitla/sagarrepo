/**
 * 
 */
package com.siri.esmartHealthCare.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ADEPARTMENT")
public class DepartmentDomine  {

	
	@Id
	@GeneratedValue
	@Column(name ="DEPTID")
	private int deptId;
	@Column(name ="DEPTNAME")
	private String deptName;
	@Column(name ="ROLEID")
	private String roleId;
	
	public int getDeptId() {
		return deptId;
	}
	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public String getRoleId() {
		return roleId;
	}
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	

}
