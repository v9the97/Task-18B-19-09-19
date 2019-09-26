package com.wp.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


import com.wp.entities.Emp;
import com.wp.services.ServiceClassSpecification;



@Controller
public class HibernateController {
	
	@Autowired
	private ServiceClassSpecification serviceclass;


	@RequestMapping("saveinputform")
	public String showSaveEmplForm()
	{
		return "saveEmp";
	}
	
	@RequestMapping("deleteinputform")
	public String showDeleteEmplForm()
	{
		return "deleteEmp";
	}
	
	@RequestMapping("searchinputform")
	public String showSearchEmplForm()
	{
		return "searchEmp";
	}
	
	@RequestMapping("updateinputform")
	public String showUpdateEmplNoForm()
	{
		return "empNoUpdate";
	}
	
	
	@RequestMapping("showFetchedForm")
	public ModelAndView showUpdateEmpForm(@ModelAttribute("info") Emp emp) {
		
		
		Emp e=serviceclass.searchEmp(emp);
		ModelAndView mv = new ModelAndView("updateEmp");
		mv.addObject("e", e);
		return mv;
	}	 
	
	@RequestMapping("save")
	public ModelAndView saveEmployee(@ModelAttribute("info") Emp emp) {
		
		
		serviceclass.addEmployee(emp);
		ModelAndView mv = new ModelAndView("addedEmpdetails");
		return mv;
	}	 
	
	@RequestMapping("delete")
	public ModelAndView deleteEmployee(@ModelAttribute ("info") Emp emp)
	{
		Emp e=serviceclass.removeEmployee(emp);
		if(e!=null)
		{
		emp.setEname(e.getEname());
		emp.setEno(e.getEno());
		emp.setSal(e.getSal());
		ModelAndView mv=new ModelAndView("deletedEmpdetails");
		return mv;
		}
		else
		{
			ModelAndView mv=new ModelAndView("deleteEmp");
			mv.addObject("deleteErr","Cannot Delete");
			
			return mv;
		}
	}
	
	@RequestMapping("search")
	public ModelAndView searchEmployee(@ModelAttribute ("info") Emp emp)
	{
		Emp e=serviceclass.searchEmp(emp);
		
		emp.setEname(e.getEname());
		emp.setEno(e.getEno());
		emp.setSal(e.getSal());
		ModelAndView mv=new ModelAndView("searchedEmpdetails");
		 
		return mv;
	}
	
	@RequestMapping("update")
	public ModelAndView updateEmployee(@ModelAttribute ("info") Emp emp)
	{
		Emp e=serviceclass.updateEmp(emp);
		emp.setEname(e.getEname());
		emp.setEno(e.getEno());
		emp.setSal(e.getSal());
		ModelAndView mv=new ModelAndView("updatedEmpdetails");
		return mv;
	}
	
	@RequestMapping("viewallEmployees")
	public ModelAndView showAllEmployees()
	{
		List<Emp> empList=serviceclass.viewAllEmployees();
		ModelAndView mv=new ModelAndView("ViewEmpDetails");
		mv.addObject("empList", empList);
		return mv;
		
	}
}
