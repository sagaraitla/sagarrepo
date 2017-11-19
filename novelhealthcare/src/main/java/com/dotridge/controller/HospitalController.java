package com.dotridge.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dotridge.bean.HospitalBean;
import com.dotridge.service.HospitalService;
import com.dotridge.util.ServiceConstants;	

@Controller
@RequestMapping("/hospitalManagement")
public class HospitalController {
	@Autowired
	private HospitalService hospitalService;

	@RequestMapping(value = "/getAllHospitals")
	public String viewAllHospitals(Model model) {
		try {
			List<HospitalBean> hospitalList = hospitalService.getAllHospital();
			int pageBar =(hospitalList.size()/ServiceConstants.NUMBER_OF_RECORDS_PER_PAGE)+1;
			
			System.out.println("List of Hospitals " + hospitalList.size()+"   "+"page bar size: "+pageBar);
			 int pageSize= (int) Math.round(Double.valueOf(String.valueOf(pageBar)));
			model.addAttribute("uihosplist", hospitalList);
			List pageBarList = new ArrayList();
			for(int i=0;i<pageSize;i++){
				pageBarList.add(i);
			}
			System.out.println("pagebar list size is "+pageBarList.size());
			model.addAttribute("pageBarList", pageBarList);
			return "getHospitalBoard";
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

	@RequestMapping("/getHospitalRegForm")
	public String getHospitalRegForm(Model model) {
		HospitalBean hospitalBean = new HospitalBean();
		model.addAttribute("hospitalName", hospitalBean);
		return "addHospitalFormDef";
	}

	@RequestMapping(value = "/addHospital", method = RequestMethod.POST)
	public String addHospital(@ModelAttribute("hospitalName") HospitalBean hospitalBean, Model model) {

		System.out.println("hospital reg details " + hospitalBean);
		hospitalBean = hospitalService.addHospital(hospitalBean);
		List<HospitalBean> hospitalList = null;
		if (hospitalBean.getHospitalId() > 0) {
			hospitalList = hospitalService.getAllHospital();
		}
		System.out.println("list-->" + hospitalList.size());
		model.addAttribute("uihosplist", hospitalList);

		return "getHospitalBoard";
	}

	@RequestMapping(value ="/editHospital")
	public String editHospital(HttpServletRequest request, Model model) {
		String hospitalId = request.getParameter("hospId");
		System.out.println("EditHospital:hospId " + hospitalId);
		HospitalBean hospitalBean = hospitalService.getHospitalById(Integer.parseInt(hospitalId));
		model.addAttribute("editHospBean", hospitalBean);
		return "editHospitalBoard";

	}
	@RequestMapping(value ="/updateHospital",method=RequestMethod.POST)
	public String updateHospital(@ModelAttribute("editHospBean") HospitalBean hospitalBean, Model model){
		System.out.println("Updating Hospital bean Id is "+hospitalBean.getHospitalId());
		hospitalBean=hospitalService.updateHospital(hospitalBean);
		List<HospitalBean> hospitalList = null;
		if (hospitalBean.getHospitalId() > 0) {
			hospitalList = hospitalService.getAllHospital();
		}
		model.addAttribute("uihosplist", hospitalList);
		return "getHospitalBoard";
		
	}
	
	@RequestMapping(value="/deleteHospital")
	public String deleteHospital(HttpServletRequest request,Model model){
		String hospitalId = request.getParameter("hospId");
		System.out.println("deleting hospital Id "+hospitalId);
		boolean flag =hospitalService.deleteHospital(Integer.parseInt(hospitalId));
		if(flag){
			System.out.println("Hospital Id "+hospitalId+" deleted? "+flag);
			List<HospitalBean> hospitalList = null;
			hospitalList = hospitalService.getAllHospital();
			model.addAttribute("uihosplist", hospitalList);
			return "getHospitalBoard";
			
		}else{
			return null;
		}
	}
	@RequestMapping("/getAllHosptialByPaging")
	public String getAllHospitalByPaging(HttpServletRequest request, Model model){
		System.out.println("CURRENT PAGE "+Integer.parseInt(request.getParameter("currentPage")));
		int currentPage =Integer.parseInt(request.getParameter("currentPage"));
		List<HospitalBean> hospitalList=hospitalService.getAllHospitalByPaging(currentPage, ServiceConstants.NUMBER_OF_RECORDS_PER_PAGE);
		model.addAttribute("uihosplist", hospitalList);

		return "getHospitalBoard";
	}
	
	
	@RequestMapping("/searchHospital")
	 public String searchHospital(HttpServletRequest req, Model model) {
	  String searchKey = req.getParameter("searchKey");
	  String searchValue = req.getParameter("searchValue");
	  System.out.println("searchkey "+searchKey + " searchvalue " + searchValue);
	  if ((searchKey != null && !searchKey.isEmpty()) && (searchValue != null && !searchValue.isEmpty())) {
		  	
		  List<HospitalBean> hospitalList = hospitalService.searchHospital(searchKey, searchValue);
		  model.addAttribute("uihosplist", hospitalList);
		  if(hospitalList==null){
			return "getHospitalBoard";
		  }
	  }
	return "getHospitalBoard";
	}
	
}
