package com.siri.esmartHealthCare.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.siri.esmartHealthCare.beans.SignupBean;
import com.siri.esmartHealthCare.domain.DepartmentDomine;
import com.siri.esmartHealthCare.domain.SignupDomain;
@Repository
public class SignupDaoImpl implements SignupDaoI{

	@Autowired
	private SessionFactory sf;
	
	String msg = "";
	
	@Override
	public List<String> getDepList() {
		Session hSession = sf.openSession();
		Query query = hSession.createQuery("from DepartmentDomine where roleId = (from RolemasterDomain where roleName = 'doctor')"); 
		List<DepartmentDomine> listOfDeptNames = query.list();
		//List<DepartmentBean> listofdeptbeans=new ArrayList<DepartmentBean>();
		List<String> deptNameList = new ArrayList<String>();
		 for(DepartmentDomine s: listOfDeptNames){
			 deptNameList.add(s.getDeptName());
	            System.out.println("Details :==== "+s.getDeptName());
		 }
		return deptNameList;
	}
	

	@Override
	public List<String> getRoleList() {
		System.out.println("role dao is called...");
		Session hSession = sf.openSession();
		Query query = hSession.createQuery("select roleName from RolemasterDomain"); 
		List<String> listOfRoles = query.list();
		
		for (String role : listOfRoles) {
			System.out.println(role);
		}
		return listOfRoles;
	}
	@Override
	public String saveDetails(SignupBean signupBean) {
		SignupDomain signupDomaine = new SignupDomain();
		signupDomaine.setFirstname(signupBean.getFirstname());
		signupDomaine.setMiddlename(signupBean.getMiddlename());
		signupDomaine.setLastname(signupBean.getLastname());
		signupDomaine.setGender(signupBean.getGender());
		signupDomaine.setUserid(signupBean.getUserid());
		signupDomaine.setPassword(signupBean.getPassword());
		signupDomaine.setMobilenumber(signupBean.getMobilenumber());
		signupDomaine.setEmail(signupBean.getEmail());
		signupDomaine.setDepartment(signupBean.getDepartment());
		signupDomaine.setAcceptTerm(signupBean.getAcceptTerm());
		Session hSession = sf.openSession();
		Transaction txn  = hSession.beginTransaction();
		Integer serIdValue = (Integer)hSession.save(signupDomaine);
		System.out.println(serIdValue);
		txn.commit();
		
		if(serIdValue>0){
			msg = "success";
		}else{
			msg = "fail";
		}
		hSession.close();
		return msg;
	}

	
}
