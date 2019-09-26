package com.wp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.wp.dao.EmpDaoSpecification;
import com.wp.entities.Emp;

@Service
public class ServiceClass implements ServiceClassSpecification {
	
	@Autowired
	private EmpDaoSpecification dao;
	
	public void addEmployee(@ModelAttribute("info") Emp emp)
	{
		dao.saveEmployee(emp);
	}

	
	public Emp removeEmployee(@ModelAttribute("info") Emp emp)
	{
		Emp e=dao.deleteEmployee(emp);
		return e;
	}
	
	public Emp searchEmp(@ModelAttribute("info") Emp emp)
	{
		Emp e=dao.searchEmployee(emp);
		return e;
		
	}
	
	public Emp updateEmp(@ModelAttribute("info") Emp emp)
	{
		Emp e=dao.updateEmployee(emp);
		return e;
		
	}
	
	public List<Emp> viewAllEmployees()
	{
		List<Emp> empList=dao.getAllEmployees();
		return empList;
		
	}

}
