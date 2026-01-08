package project.jsp.Employee_Management_System.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.jsp.Employee_Management_System.entity.Employee;
import project.jsp.Employee_Management_System.repository.EmployeeRepository;

@Service

public class EmployeeService 
{
	@Autowired
    private EmployeeRepository repo;
    
    //create employee
    public Employee saveEmployee(Employee e)
    {
    	return repo.save(e);
    }
    
    //get Employee by id
    
    public Employee findById(Long id)
    {
    	Optional<Employee> o = repo.findById(id);
    	if(o.isPresent())
    	{
    		return o.get();
    	}
    	else
    		return null;
    }
    
    //get all employee
    
    public List<Employee> findAll()
    {
    	return repo.findAll();
    }
    
    //delete employee
    
    public String deleteById(Long id)
    {
    	Optional<Employee> o = repo.findById(id);
    	if(o.isPresent())
    	{
    	   repo.deleteById(id);
    	   return "data deleted";
    	}
    	return "data not found";
    }
    
    //update the data
    
    public String updateDetails(Long id, Employee e)
    {
    	Optional<Employee> o = repo.findById(id);
    	if(o.isPresent())
    	{
    		Employee emp = o.get();
    		emp.setName(e.getName());
    		emp.setRole(e.getRole());
    		emp.setDepartment(e.getDepartment());
    		emp.setJoinDate(e.getJoinDate());
    		emp.setSalary(e.getSalary());
    		
    		repo.save(emp);
    		return "data updated";
    	}
    	return "data not found";
    }
}
