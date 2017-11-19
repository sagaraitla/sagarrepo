package com.dotridge.controller;

import javax.servlet.http.HttpServletRequest;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.ui.Model;
import org.springframework.validation.support.BindingAwareModelMap;

import com.dotridge.bean.HospitalBean;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations="file:webapp/WEB-INF/novelhealth-servlet.xml")
@ContextConfiguration(locations={"classpath:novelhealth-servlet.xml","classpath:applicationContext.xml"})
public class HospitalControllerTest {
	
	@Autowired
	HospitalController hospitalController;
	
	@Autowired
	HttpServletRequest request;
	
	Model model;
	
	@Before
	public void setUp(){
		model= new BindingAwareModelMap();
	}
	
	@Test
	public void testGetAllHospital(){
		String viewName =hospitalController.viewAllHospitals(model);
		Assert.assertNotNull(viewName);
		Assert.assertEquals("getHospitalBoard", viewName);
	}
	
	@Test
	public void testAddHospital(){
		HospitalBean hospitalBean = new HospitalBean();
		hospitalBean.setHospitalName("govinda");
		hospitalBean.setEmail("g@hotmail.com");
		hospitalBean.setStatus("active");
		hospitalBean.setAddress1("miyapur");
		String viewName =hospitalController.addHospital(hospitalBean, model);
		
		Assert.assertNotNull(viewName);
		Assert.assertEquals("getHospitalBoard", viewName);
	}
	
	

}
