package com.dotridge.service;

import java.util.List;

import com.dotridge.bean.HospitalBean;

public interface HospitalService {
	public HospitalBean addHospital(HospitalBean hostpitalBean);

	public boolean deleteHospital(int hospitalId);

	public boolean activateHospital(int hospitalId);

	public boolean inactivateHospital(int hospitalId);

	public List<HospitalBean> getAllHospital();

	/*public List<HospitalBean> searchHospital(String hospitalName, String address1, String email, long phone,
			String status);*/
	
	public List<HospitalBean> searchHospital(String searchKey,String searchValue);

	public HospitalBean getHospitalById(int hospitalId);
	
	public HospitalBean updateHospital(HospitalBean hostpitalBean);
	
	
	public List<HospitalBean> getAllHospitalByPaging(int currentPage,int noOfRecordsByPage);

	/*public List<HospitalBean> searchHospitalByName(String hospitalName);

	public List<HospitalBean> searchHospitalByEmail(String email);

	public List<HospitalBean> searchHospitalByAddress1(String address1);

	public List<HospitalBean> searchHospitalByPhone(String phone);

	public List<HospitalBean> searchHospitalByStatus(String searchValue);*/
}
