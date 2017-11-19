package com.dotridge.service;

import java.util.List;

import com.dotridge.bean.AdminBean;
import com.dotridge.bean.HospitalBean;

public interface AdminService {

	public List<AdminBean> getAllAdmins();
	
	public AdminBean addAdmin(AdminBean adminBean);
	
	public boolean deleteAdmin(int adminId);
	
	public boolean activateAdmin(int adminId);

	public boolean inactivateAdmin(int adminId);
	
	public List<AdminBean> searchAdmin(String searchKey,String searchValue);

	public AdminBean getAdminById(int adminId);
	
	public AdminBean updateAdmin(AdminBean adminBean);
	
	
	public List<AdminBean> getAllAdminByPaging(int currentPage,int noOfRecordsByPage);
}
