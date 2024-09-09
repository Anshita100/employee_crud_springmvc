package com.becoder.dao;

import java.util.List;

import com.becoder.model.Employee;

public interface EmpDao {

	public int saveEmp(Employee emp);
	
	public Employee getEmpById(int id);
	
	public List<Employee> getAllEmp();
	
	public void update(Employee emp);
	
	public void deleteEmp(int id);
}
