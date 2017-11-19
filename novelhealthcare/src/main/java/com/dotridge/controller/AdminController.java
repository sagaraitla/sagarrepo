package com.dotridge.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dotridge.bean.AdminBean;
import com.dotridge.bean.HospitalBean;
import com.dotridge.service.AdminService;
import com.dotridge.service.HospitalService;

@Controller
@RequestMapping("/adminManagement")
public class AdminController {

	@Autowired
	private AdminService adminService;
	
	@Autowired
	private HospitalService hospitalService;
	
	@RequestMapping(value = "/getAllAdmins")
	public String viewAdmins(Model model) {
		System.out.println("AdminController: viewAdmins(-)");
		List<AdminBean> listOfAdminBeans = adminService.getAllAdmins();
		model.addAttribute("uiAdminsList", listOfAdminBeans);
		System.out.println("AdminController: admin list size "+listOfAdminBeans.size());
		return "getAdminBoard";
	}
	
	@RequestMapping(value="/getAdminRegForm")
	public String getHospitalRegForm(Model model) {//model is resouce injection
		System.out.println("AdminController:getHospitalRegForm(-)");
		List<HospitalBean> hospitalbeans=hospitalService.getAllHospital();
		Set<String> hospitalNames = getAllHospitalNames(hospitalbeans);
		System.out.println("Hospital Name list: "+hospitalNames);
		model.addAttribute("hospitalNames", hospitalNames);
		AdminBean adminBean = new AdminBean();
		model.addAttribute("adminBean", adminBean);
		return "addAdminFormDef";
	}
	
	@RequestMapping(value="/addAdmin",method=RequestMethod.POST)
	public String addAdmin(@ModelAttribute("adminBean") AdminBean adminBean,Model model) {
		System.out.println("AdminBean "+adminBean);
		adminBean = adminService.addAdmin(adminBean);
		List<AdminBean> listOfAdminBeans = null;
		if(adminBean.getAdminId()>0){
			listOfAdminBeans = adminService.getAllAdmins();
		}
		model.addAttribute("uiAdminsList", listOfAdminBeans);
		return "getAdminBoard";
	}
	
	@RequestMapping(value ="/editAdmin")
	public String editAdmin(HttpServletRequest request, Model model) {
		String adminId = request.getParameter("adminId");
		System.out.println("EditAdmin:adminId " + adminId);
		
		AdminBean adminBean = adminService.getAdminById(Integer.parseInt(adminId));
		model.addAttribute("editAdminBean", adminBean);
		return "editAdminBoard";

	}
	
	@RequestMapping(value ="/updateAdmin",method=RequestMethod.POST)
	public String updateAdmin(@ModelAttribute("editAdminBean") AdminBean adminBean, Model model){
		System.out.println("Updating Admin bean Id is "+adminBean.getAdminId());
		adminBean=adminService.updateAdmin(adminBean);
		List<AdminBean> adminList = null;
		if (adminBean.getAdminId() > 0) {
			adminList = adminService.getAllAdmins();
		}
		model.addAttribute("uiAdminsList", adminList);
		return "getAdminBoard";
		
	}
	
	
	@RequestMapping(value="/deleteAdmin")
	public String deleteAdmin(HttpServletRequest request,Model model){
		String adminId = request.getParameter("adminId");
		System.out.println("deleting Admin Id is "+adminId);
		boolean flag =adminService.deleteAdmin(Integer.parseInt(adminId));
		if(flag){
			System.out.println("Admin Id "+adminId+" deleted? "+flag);
			List<AdminBean> adminList = null;
			adminList = adminService.getAllAdmins();
			model.addAttribute("uiAdminsList", adminList);
			return "getAdminBoard";
			
		}else{
			return "getAdminBoard";
		}
	}
	
	@RequestMapping("/searchAdmin")
	 public String searchHospital(HttpServletRequest req, Model model) {
	  String searchKey = req.getParameter("searchKey");
	  String searchValue = req.getParameter("searchValue");
	  System.out.println("searchkey "+searchKey + " searchvalue " + searchValue);
	  if ((searchKey != null && !searchKey.isEmpty()) && (searchValue != null && !searchValue.isEmpty())) {
		  List<AdminBean> adminList = adminService.searchAdmin(searchKey, searchValue);
		  model.addAttribute("uiAdminsList", adminList);
		  if(adminList==null){
			return "getAdminBoard";
		  }
	  }
	return "getAdminBoard";
	}
	
	
	
	
	
	private Set<String> getAllHospitalNames(List<HospitalBean> hospitalbeans){
		Set<String> hospitalNames = new HashSet<String>();
		Iterator<HospitalBean> hospBeans =hospitalbeans.iterator();
		while(hospBeans.hasNext()){
			String hospitalName =hospBeans.next().getHospitalName();
			if(hospitalName != null){
				hospitalNames.add(hospitalName);
			}
		}
		return hospitalNames;
		
	}

}
