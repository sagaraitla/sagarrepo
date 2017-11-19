package com.siri.esmartHealthCare.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.siri.esmartHealthCare.beans.SignupBean;
import com.siri.esmartHealthCare.dao.SignupDaoI;

@Service
public class SignupServicesImpl implements SignupServicesI{
	@Autowired
	private SignupDaoI signupDao;
	@Override
	public List<String> getDepList() {
		// List<DepartmentBean> deptList
		List<String> deptList = signupDao.getDepList();
		return deptList;
	}
	
	@Override
	public List<String> getRoleList() {
		List<String> roleList = signupDao.getRoleList();
		return roleList;
	}
	
	@Override
	public String saveDetails(SignupBean signupBean) {
		String msg = signupDao.saveDetails(signupBean);
		
		return msg;
	}
	

}
