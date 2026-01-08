package project.jsp.Employee_Management_System.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import project.jsp.Employee_Management_System.service.SalaryService;

@RestController
@RequestMapping("/salary")
public class SalaryController 
{
   @Autowired
   private SalaryService service;
   
  @GetMapping("/{empId}")
 public String calculateSalary(@PathVariable Long empId,@RequestParam LocalDate st,@RequestParam LocalDate end)
 {
	 double salary= service.calculateSalary(empId, st, end);
	 
	 if(salary==-2)
	 {
		 return "employee not found";
	 }
	 if(salary==-1)
	 {
		 return "Salary calculation is allowed only within the same month";
	 }
	 
	 return "Calculated salary: "+ salary;
 }
 }
   
