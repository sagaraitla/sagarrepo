package com.dotridge.dao;

import java.util.List;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.dotridge.domain.Hospital;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext.xml")
public class HospitalDaoTest {

	@Autowired
	HospitalDao hospitalDao;
	
	@Test
	@Ignore
	public void testGetAllHospitals(){
		List<Hospital> allHospital = hospitalDao.getAllHospital();
		Assert.assertNotNull(allHospital);
		//Assert.assertNotEquals(10, allHospital.size());
		Assert.assertEquals(16, allHospital.size());
	}
	
}
