package com.dotridge.dao;

import java.util.List;

import com.dotridge.bean.HospitalBean;
import com.dotridge.domain.Hospital;

public interface HospitalDao {

	public Hospital addHospital(Hospital hostpital);

	public boolean deleteHospital(int hospitalId);

	public String activateHospital(int hospitalId);

	public String inactivateHospital(int hospitalId);

	public List<Hospital> getAllHospital();

	public Hospital getHospitalByName(String hospitalName);
	//public List<Hospital> searchHospital(String searchKey,String searchValue);
	
	public Hospital getHospitalById(int hospitalId);
	
	public Hospital updateHospital(Hospital hostpital);
	
	public List<Hospital> getAllHospitalByPaging(int currentPage,int totalRecordsByPage);

	public List<Hospital> searchHospitalByName(String hospitalName);

	public List<Hospital> searchHospitalByEmail(String searchValue);

	public List<Hospital> searchHospitalByAddress1(String address1);

	public List<Hospital> searchHospitalByPhone(long phone);

	public List<Hospital> searchHospitalByStatus(String status);

}
