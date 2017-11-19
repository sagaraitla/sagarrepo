package com.dotridge.dao;

import java.util.List;

import com.dotridge.domain.Admin;
import com.dotridge.domain.Hospital;

public interface AdminDao {

	public Admin addAdmin(Admin admin);

	public boolean deleteAdmin(int adminId);

	public String activateAdmin(int adminId);

	public String inactivateAdmin(int adminId);

	public List<Admin> getAllAdmins();

	public Admin getAdminById(int adminId);
	
	public Admin updateAdmin(Admin admin);
	
	public List<Admin> searchAdminByFirstName(String adminFirstName);

	public List<Admin> searchAdminByEmail(String email);

	public List<Admin> searchAdminByPhone(long phone);

	public List<Admin> searchAdminByStatus(String status);
	
	public List<Admin> getAllAdminByPaging(int currentPage,int totalRecordsByPage);

}
