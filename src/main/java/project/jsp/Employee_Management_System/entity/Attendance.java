package project.jsp.Employee_Management_System.entity;

import java.time.LocalDate;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Attendance 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   private LocalDate date;
   private String status;
   
   @ManyToOne
   private Employee employee;

   public Long getId() {
	return id;
   }

   public void setId(Long id) {
	this.id = id;
   }

   public LocalDate getDate() {
	return date;
   }

   public void setDate(LocalDate date) {
	this.date = date;
   }

   public String getStatus() {
	return status;
   }

   public void setStatus(String status) {
	this.status = status;
   }

   public Employee getEmployee() {
	return employee;
   }

   public void setEmployee(Employee employee) {
	this.employee = employee;
   }
   
   
}
