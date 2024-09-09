package com.becoder.controller;

import java.util.List;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.becoder.dao.EmpDao;
import com.becoder.model.Employee;


@Controller
public class HomeController {

	@Autowired
	private EmpDao Empdao;
	
	@RequestMapping("/home")
	public String home()
	{
		return "home";
	}
	@RequestMapping("/addEmp")
	public String addEmp()
	{
		return "addEmp";
	}
	@RequestMapping(path="/addEmp" ,method=RequestMethod.POST)
	public String addEmp1(@ModelAttribute Employee e,HttpSession session)
	{
		System.out.println(e);
		int id=Empdao.saveEmp(e);
		session.setAttribute("msg", "Register successfully");
		return "redirect:/addEmp";
	}
	@RequestMapping("/showall")
	public String showall(Model m)
	{
		List<Employee> list=Empdao.getAllEmp();
		m.addAttribute("emplist",list);
		return "showall";
	}
	@RequestMapping("/edit/{id}")
	public String edit(@PathVariable int id,Model m)
	{
		Employee e=Empdao.getEmpById(id);
		m.addAttribute("e",e);
		return "edit";
	}
	@RequestMapping(path="/updateEmp" ,method=RequestMethod.POST)
	public String updateEmp1(@ModelAttribute Employee e,HttpSession session)
	{
		System.out.println(e);
		Empdao.update(e);
		session.setAttribute("msg", "updated successfully");
		return "redirect:/home";
	}
	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable int id,HttpSession session)
	{
		Empdao.deleteEmp(id);
		session.setAttribute("msg", "deleted successfully");
		return "redirect:/home";
	}
}
