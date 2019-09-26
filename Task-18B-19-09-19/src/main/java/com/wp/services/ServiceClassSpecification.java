package com.wp.services;

import java.util.List;

import org.springframework.web.bind.annotation.ModelAttribute;

import com.wp.entities.Emp;

public interface ServiceClassSpecification {

	public void addEmployee(@ModelAttribute("info") Emp emp);
	public Emp removeEmployee(@ModelAttribute("info") Emp emp);
	public Emp searchEmp(@ModelAttribute("info") Emp emp);
	public Emp updateEmp(@ModelAttribute("info") Emp emp);
	public List<Emp> viewAllEmployees();
}
