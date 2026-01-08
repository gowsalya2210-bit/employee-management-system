package project.jsp.Employee_Management_System.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import project.jsp.Employee_Management_System.entity.Attendance;
import project.jsp.Employee_Management_System.service.AttendanceService;

@RestController
@RequestMapping("/attendance")
public class AttendanceController 
{
	@Autowired
   private AttendanceService service;
	
	//save
	@PostMapping("/{empId}")
	public Attendance save(@PathVariable Long empId,@RequestBody Attendance a)
	{
		return service.save(empId, a);
	}
   
	//Get all attendance records
	@GetMapping
	public List<Attendance> findAll()
	{
		return service.findAll();
	}
	
	//get attendance by id
	@GetMapping("/{id}")
	public Attendance findById(@PathVariable Long id)
	{
		return service.findById(id);
	}
	
	//delete
	  @DeleteMapping("/{id}")
		public String deleteAttendance(@PathVariable Long id)
		{
			return service.deleteAttendance(id);
		}
		
		//update
	    @PutMapping("/{id}")
		public Attendance updateAttendance(@PathVariable Long id,@RequestBody String status)
		{
			return service.updateAttendance(id, status);
		}
}
