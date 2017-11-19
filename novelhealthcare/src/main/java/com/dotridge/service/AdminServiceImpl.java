package com.dotridge.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dotridge.bean.AdminBean;
import com.dotridge.bean.HospitalBean;
import com.dotridge.dao.AdminDao;
import com.dotridge.dao.HospitalDao;
import com.dotridge.domain.Admin;
import com.dotridge.domain.Hospital;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminDao adminDao;
	
	@Autowired
	private HospitalDao hospitalDao;

	public List<AdminBean> getAllAdmins() {
		System.out.println("AdminServiceImpl:getAllAdmins()");
		List<Admin> adminList = adminDao.getAllAdmins();
		System.out.println("adminList size "+adminList.size());
		List<AdminBean> adminBeanList = null;
		if (adminList != null && !adminList.isEmpty()) {
			adminBeanList = adminDomainListToBeanList(adminList);
			return adminBeanList;
		} else {
			throw new RuntimeException("No admins are aviable");
		}
	}

	public AdminBean addAdmin(AdminBean adminBean) {
		System.out.println("AdminServiceImpl:addAdmin()");
		Admin admin =mapBeanToDomain(adminBean);
		String hospitalName = adminBean.getHospitalName();
		Hospital hospital =hospitalDao.getHospitalByName(hospitalName);
		admin.setHospital(hospital);
		admin =adminDao.addAdmin(admin);
		adminBean = mapDomainToBean(admin);
		return adminBean;
	}
	
	public boolean deleteAdmin(int adminId) {
		System.out.println("AdminServiceImpl:deleteAdmin()");
		boolean flag= false;
		flag=adminDao.deleteAdmin(adminId);
		return flag;
	}

	public boolean activateAdmin(int adminId) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean inactivateAdmin(int adminId) {
		// TODO Auto-generated method stub
		return false;
	}

	public List<AdminBean> searchAdmin(String searchKey, String searchValue) {
		System.out.println("AdminServiceImpl:searchAdmin()");
		List<Admin> adminDomainlist = null;
		List<AdminBean> adminBeanList = new ArrayList<AdminBean>();
		if ((searchKey != null && !searchKey.isEmpty()) && (searchValue != null && !searchValue.isEmpty())) {
			if (searchKey.equalsIgnoreCase("firstName")) {
				adminDomainlist = adminDao.searchAdminByFirstName(searchValue);
				adminBeanList = adminDomainListToBeanList(adminDomainlist);
				return adminBeanList;
			}
			if (searchKey.equalsIgnoreCase("email")) {
				adminDomainlist = adminDao.searchAdminByEmail(searchValue);
				adminBeanList = adminDomainListToBeanList(adminDomainlist);
				return adminBeanList;
			}
			if (searchKey.equalsIgnoreCase("Phone")) {
				adminDomainlist = adminDao.searchAdminByPhone(Long.parseLong(searchValue));
				adminBeanList = adminDomainListToBeanList(adminDomainlist);
				return adminBeanList;
			}
			if (searchKey.equalsIgnoreCase("status")) {
				adminDomainlist = adminDao.searchAdminByStatus(searchValue);
				adminBeanList = adminDomainListToBeanList(adminDomainlist);
				return adminBeanList;
			}
		}
		return adminBeanList;
	}

	public AdminBean getAdminById(int adminId) {
		System.out.println("AdminServiceImpl:getAdminById()");
		Admin adminDomin=adminDao.getAdminById(adminId);
		return mapDomainToBean(adminDomin);
	}

	public AdminBean updateAdmin(AdminBean adminBean) {
		System.out.println("AdminServiceImpl:updateAdmin()");
		Admin adminDomin = mapBeanToDomain(adminBean);
		adminDomin = adminDao.updateAdmin(adminDomin);
		adminBean =mapDomainToBean(adminDomin);
		return adminBean;
	}

	public List<AdminBean> getAllAdminByPaging(int currentPage, int noOfRecordsByPage) {
		System.out.println("AdminServiceImpl:getAllAdminByPaging()");
		List<Admin> listOfAdmins = adminDao.getAllAdminByPaging(currentPage, noOfRecordsByPage);
		List<AdminBean> listOfAdminBean = null;
		if (listOfAdmins.size() > 0) {
			listOfAdminBean = new ArrayList<AdminBean>();
			Iterator iterator = listOfAdmins.iterator();
			while (iterator.hasNext()) {
				Admin admin = (Admin) iterator.next();
				AdminBean adminBean = mapDomainToBean(admin);
				listOfAdminBean.add(adminBean);
			}
		}
		return listOfAdminBean;
	}

	private Admin mapBeanToDomain(AdminBean adminBean) {
		Admin admin = new Admin();
		if(adminBean.getAdminId()>0){//while updating Admin this becomes true
			admin.setId(adminBean.getAdminId());
		}
		admin.setFirstName(adminBean.getFirstName());
		admin.setMiddleName(adminBean.getMiddleName());
		admin.setLastName(adminBean.getMiddleName());
		admin.setEmail(adminBean.getEmail());
		admin.setPassword(adminBean.getPassword());
		if(adminBean.getPhone() != null && !adminBean.getPhone().isEmpty()){
			admin.setPhone(Long.parseLong(adminBean.getPhone()));
		}
		admin.setProfileDocument(adminBean.getProfileDocument());
		admin.setStatus(adminBean.getStatus());
		
		return admin;
	}

	private AdminBean mapDomainToBean(Admin adminDomain) {
		AdminBean adminBean = new AdminBean();
		adminBean.setAdminId(adminDomain.getId());
		adminBean.setFirstName(adminDomain.getFirstName());
		adminBean.setMiddleName(adminDomain.getMiddleName());
		adminBean.setLastName(adminDomain.getLastName());
		adminBean.setPhone(String.valueOf(adminDomain.getPhone()));
		adminBean.setEmail(adminDomain.getEmail());
		adminBean.setPassword(adminDomain.getPassword());
		adminBean.setStatus(adminDomain.getStatus());
		
		return adminBean;
	}

	
	private List<AdminBean> adminDomainListToBeanList(List<Admin> adminDomainlist){
		List<AdminBean> adminBeanList=new ArrayList<AdminBean>();
		for (Admin admin : adminDomainlist) {
			AdminBean adminBean = mapDomainToBean(admin);
			adminBeanList.add(adminBean);
		}
		return adminBeanList;
	   
	}

}
