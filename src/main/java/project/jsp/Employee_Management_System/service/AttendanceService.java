package project.jsp.Employee_Management_System.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.jsp.Employee_Management_System.entity.Attendance;
import project.jsp.Employee_Management_System.entity.Employee;
import project.jsp.Employee_Management_System.repository.AttendanceRepository;
import project.jsp.Employee_Management_System.repository.EmployeeRepository;

@Service
public class AttendanceService 
{
	@Autowired
   private AttendanceRepository attendanceRepo;
	@Autowired
   private EmployeeRepository employeeRepo;
	
	//save
	public Attendance save(Long empId, Attendance a)
	{
		Optional<Employee> o = employeeRepo.findById(empId);
		if(o.isPresent())
		{
		   a.setEmployee(o.get());
		  return attendanceRepo.save(a);
		}
		return null;
	}
	
	//Get all attendance records
	public List<Attendance> findAll()
	{
		return attendanceRepo.findAll();
	}
	
	//get attendance by id
	public Attendance findById(Long id)
	{
		Optional<Attendance> o = attendanceRepo.findById(id);
		if(o.isPresent())
		{
			return o.get();
		}
		return null;
	}
	
	//delete
	public String deleteAttendance(Long id)
	{
		if(attendanceRepo.existsById(id))
		{
			attendanceRepo.deleteById(id);
			return "Attendence record deleted";
		}
		return "Attendance record not found";
	}
	
	//update
	public Attendance updateAttendance(Long id, String status)
	{
		Optional<Attendance> o = attendanceRepo.findById(id);
		if(o.isPresent())
		{
			Attendance attendance = o.get();
			attendance.setStatus(status);
			return attendanceRepo.save(attendance);
		}
		return null;
	}
}
