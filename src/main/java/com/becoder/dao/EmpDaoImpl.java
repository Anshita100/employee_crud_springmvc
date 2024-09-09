package com.becoder.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.becoder.model.Employee;

@Repository
public class EmpDaoImpl implements EmpDao{
	
	@Autowired
	private HibernateTemplate hibernateTemplate;

	
	@Transactional
	public int saveEmp(Employee emp) {
		// TODO Auto-generated method stub
		int id=(Integer) hibernateTemplate.save(emp);
		return id;
	}

	@Override
	public Employee getEmpById(int id) {
		// TODO Auto-generated method stub
		Employee e=hibernateTemplate.get(Employee.class, id);
		return e;
	}

	@Override
	public List<Employee> getAllEmp() {
		// TODO Auto-generated method stub
		List<Employee> mylist=hibernateTemplate.loadAll(Employee.class);
		return mylist;
	}

	@Transactional
	public void update(Employee emp) {
		// TODO Auto-generated method stub
		hibernateTemplate.update(emp);
		
	}

	@Transactional
	public void deleteEmp(int id) {
		// TODO Auto-generated method stub
		Employee e=hibernateTemplate.get(Employee.class, id);
		hibernateTemplate.delete(e);
	}

}
