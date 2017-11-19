package com.dotridge.dao;

import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.dotridge.domain.Hospital;

public class HospitalDaoTest_Unit {

	
	private HospitalDao hospitalDao;
	
	@Before
	public void setUp(){
		hospitalDao= new HospitalDaoImpl();
	}
	
	
	@Test
	public void testGetAllHospitals(){
		List<Hospital> allHospital = hospitalDao.getAllHospital();
		Assert.assertNotNull(allHospital);
		//Assert.assertNotEquals(10, allHospital.size());
		Assert.assertEquals(10, allHospital.size());
	}
	
	@Test
	public void testAddHospital(){
		
		Hospital hospital = new Hospital();
		hospital.setHospitalName("h11");
		hospital.setAddress1("myaddress1");
		/*hospital.setEmail("Vrm@gmail.com");
		hospital.setAddress1("Ekarm");
		hospital.setCity("wQQrangal");
		hospital.setState("TwS");
		hospital.setFax("kqqremax");
		hospital.setZipCode(456153l);
		hospital.setPhone(56779925);
		hospital.setStatus("active");*/
		
		Hospital hosp2 = (Hospital)hospital.clone();
		
		System.out.println("actual  "+hospital.getId());
		Hospital hosp3 = hospitalDao.addHospital(hosp2);
		//Hospital hosp3 =(Hospital)hospital2.clone();
		System.out.println("database "+hosp3.getId());
		
		Assert.assertNotEquals(hospital, hosp3);
	//	Assert.assertNotSame(hosp2, hospital2);
		//Assert.assertEquals("war", hospital.getCity());
		
		
	}
	
	@After
	public void tearDown(){
		hospitalDao=null;
	}
}
