package com.dotridge.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dotridge.bean.HospitalBean;
import com.dotridge.dao.HospitalDao;
import com.dotridge.domain.Hospital;
@Service
public class HospitalServiceImpl implements HospitalService{
	@Autowired
	private HospitalDao hospitalDao;
	public HospitalBean addHospital(HospitalBean hospitalBean) {
		System.out.println("HospitalServiceImpl:addHospital()");
		Hospital hospitalDomain =mapBeanToDomain(hospitalBean);
		hospitalDomain =hospitalDao.addHospital(hospitalDomain);
		hospitalBean =mapDomainToBean(hospitalDomain);
		return hospitalBean;
	}

	public boolean deleteHospital(int hospitalId) {
		System.out.println("HospitalServiceImpl:deleteHospital()");
		boolean flag= false;
		flag=hospitalDao.deleteHospital(hospitalId);
		return flag;
	}

	public boolean activateHospital(int hospitalId) {
		System.out.println("HospitalServiceImpl:activateHospital()");
		// TODO Auto-generated method stub
		return false;
	}

	public boolean inactivateHospital(int hospitalId) {
		System.out.println("HospitalServiceImpl:inactivateHospital()");
		// TODO Auto-generated method stub
		return false;
	}

	public List<HospitalBean> getAllHospital() {
		System.out.println("HospitalServiceImpl :getAllHospital()");
		List<Hospital> hosplist=hospitalDao.getAllHospital();
		List<HospitalBean> uihosplist=null;
		if(hosplist !=null && !hosplist.isEmpty()){
			uihosplist=new ArrayList<HospitalBean>();
			for (Hospital hospitalDomain : hosplist) {
				HospitalBean hospBean=mapDomainToBean(hospitalDomain);
				uihosplist.add(hospBean);
			}
			System.out.println("HospitalBean list size "+uihosplist.size());
			return uihosplist;
		}
		else{ 
			throw new RuntimeException("No Hosp are aviable");
		}
	}

	

	public List<HospitalBean> searchHospital(String searchKey, String searchValue) {
		System.out.println("HospitalServiceImpl:searchHospital()");
		List<Hospital> hosptialDomainlist = null;
		List<HospitalBean> hospitalBeanList = new ArrayList<HospitalBean>();
		if ((searchKey != null && !searchKey.isEmpty()) && (searchValue != null && !searchValue.isEmpty())) {
			if (searchKey.equalsIgnoreCase("hospitalName")) {
				hosptialDomainlist = hospitalDao.searchHospitalByName(searchValue);
				hospitalBeanList = hosptialDomainListToBeanList(hosptialDomainlist);
				return hospitalBeanList;
			}
			if (searchKey.equalsIgnoreCase("email")) {
				hosptialDomainlist = hospitalDao.searchHospitalByEmail(searchValue);
				hospitalBeanList = hosptialDomainListToBeanList(hosptialDomainlist);
				return hospitalBeanList;
			}
			if (searchKey.equalsIgnoreCase("Address1")) {
				hosptialDomainlist = hospitalDao.searchHospitalByAddress1(searchValue);
				hospitalBeanList = hosptialDomainListToBeanList(hosptialDomainlist);
				return hospitalBeanList;
			}
			if (searchKey.equalsIgnoreCase("Phone")) {
				hosptialDomainlist = hospitalDao.searchHospitalByPhone(Long.parseLong(searchValue));
				hospitalBeanList = hosptialDomainListToBeanList(hosptialDomainlist);
				return hospitalBeanList;
			}
			if (searchKey.equalsIgnoreCase("status")) {
				hosptialDomainlist = hospitalDao.searchHospitalByStatus(searchValue);
				hospitalBeanList = hosptialDomainListToBeanList(hosptialDomainlist);
				return hospitalBeanList;
			}
		}
		return hospitalBeanList;
	}

	public HospitalBean getHospitalById(int hospitalId) {
		System.out.println("HospitalServiceImpl:getHospitalById()");
		Hospital hospital	=hospitalDao.getHospitalById(hospitalId);
		return mapDomainToBean(hospital);
	}
	public Hospital mapBeanToDomain(HospitalBean hospitalBean) 
	{
		Hospital hospital = new Hospital();
		if(hospitalBean.getHospitalId()>0){//while updating hospital this becomes true
			hospital.setId(hospitalBean.getHospitalId());
		}
		hospital.setHospitalName(hospitalBean.getHospitalName());
		hospital.setAddress1(hospitalBean.getAddress1());
		hospital.setAddress2(hospitalBean.getAddress2());
		hospital.setCity(hospitalBean.getCity());
		hospital.setState(hospitalBean.getState());
		if(hospitalBean.getPhone() !=null && !hospitalBean.getPhone().isEmpty()){
			hospital.setZipCode(Long.parseLong(hospitalBean.getPhone()));
		}
		hospital.setEmail(hospitalBean.getEmail());
		if(hospitalBean.getPhone() !=null && !hospitalBean.getPhone().isEmpty()){
			hospital.setPhone(Long.parseLong(hospitalBean.getPhone()));
		}
		hospital.setFax(hospitalBean.getFax());
		//hospital.setLogo(hospitalBean.getLogo());
		//hospital.setRegistrationDocument(hospitalBean.getRegistrationDocument());
		hospital.setStatus(hospitalBean.getStatus());
		/*hospital.setCreatedBy("Yugandhar");
		hospital.setCreatedDate(date);
		hospital.setModifiedBy("Yugandhar");
		hospital.setModifiedDate(date);*/
		return hospital;
	}

	public HospitalBean mapDomainToBean(Hospital hospitalDomain) 
	{
		HospitalBean hospitalBean = new HospitalBean();
		hospitalBean.setHospitalId(hospitalDomain.getId());
		hospitalBean.setHospitalName(hospitalDomain.getHospitalName());
		hospitalBean.setAddress1(hospitalDomain.getAddress1());
		hospitalBean.setAddress2(hospitalDomain.getAddress2());
		hospitalBean.setCity(hospitalDomain.getCity());
		hospitalBean.setState(hospitalDomain.getState());
		hospitalBean.setEmail(hospitalDomain.getEmail());
		hospitalBean.setZipcode(String.valueOf(hospitalDomain.getZipCode()));
		hospitalBean.setPhone(String.valueOf(hospitalDomain.getZipCode()));
		hospitalBean.setFax(hospitalDomain.getFax());
		//hospitalBean.setLogo(hospitalDomain.getLogo());
		//hospitalBean.setRegistrationDocument(hospitalDomain.getRegistrationDocument());
		hospitalBean.setStatus(hospitalDomain.getStatus());
		return hospitalBean;
	}

	public HospitalBean updateHospital(HospitalBean hostpitalBean) {
		System.out.println("HospitalServiceImpl:deleteHospital()");
		Hospital hospitalDomain = mapBeanToDomain(hostpitalBean);
		hospitalDomain = hospitalDao.updateHospital(hospitalDomain);
		return mapDomainToBean(hospitalDomain);
	}

	public List<HospitalBean> getAllHospitalByPaging(int currentPage, int noOfRecordsByPage) {
		System.out.println("HospitalServiceImpl:getAllHospitalByPaging()");
		List<Hospital> listOfHospital = hospitalDao.getAllHospitalByPaging(currentPage, noOfRecordsByPage);
		List<HospitalBean> listOfHospitalBean = null;
		if (listOfHospital.size() > 0) {
			listOfHospitalBean = new ArrayList<HospitalBean>();
			Iterator iterator = listOfHospital.iterator();
			while (iterator.hasNext()) {
				Hospital hospital = (Hospital) iterator.next();
				HospitalBean hosptialBean = mapDomainToBean(hospital);
				listOfHospitalBean.add(hosptialBean);
			}
		}
		return listOfHospitalBean;
	}

	public List<HospitalBean> getAllHospitalForAdminDropDown() {
		System.out.println("HospitalServiceImpl :getAllHospitalForAdminDropDown()");
		List<Hospital> hosplist=hospitalDao.getAllHospital();
		List<HospitalBean> uihosplist=null;
		if(hosplist !=null && !hosplist.isEmpty()){
			uihosplist=new ArrayList<HospitalBean>();
			for (Hospital hospitalDomain : hosplist) {
				HospitalBean hospBean=mapDomainToBean(hospitalDomain);
				uihosplist.add(hospBean);
			}
			System.out.println("HospitalBean list size "+uihosplist.size());
			return uihosplist;
		}
		else{ 
			throw new RuntimeException("No Hosp are aviable");
		}
	}
	
	private List<HospitalBean> hosptialDomainListToBeanList(List<Hospital> hosptialDomainlist){
		List<HospitalBean> hospitalBeanList=new ArrayList<HospitalBean>();
		for (Hospital hospital : hosptialDomainlist) {
			HospitalBean hospitalBean = mapDomainToBean(hospital);
			hospitalBeanList.add(hospitalBean);
		}
		return hospitalBeanList;
	   
	}
	

}
