package com.Employee.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.Employee.bean.Employee;
import com.Employee.dao.EmployeeRepository;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller
public class Employeecontroller {
	
	@Autowired
	EmployeeRepository er;
	
	@RequestMapping("/home")
	public ArrayList home(HttpServletRequest req, HttpServletResponse res) {
		
		ArrayList list = new ArrayList();
		
		
		for(Employee e: er.findAll()) {
			
			list.add(e);
		}
		
		HttpSession session = req.getSession();
		session.setAttribute("Employee", list);
		
		return list;
			
		}
	
	@RequestMapping("/register")
	public String register() {
		return "register";
		
	}
	
	@RequestMapping("/Employeeregister")
	public String Employeeregister(Employee e) {
		
		er.save(e);
		return "redirect:/home";
	}
	
	@RequestMapping("/deleteEmployee")
	public String deleteEmployee( Employee e) {
		
		er.deleteById(e.getId());
		
		return "redirect:/home";
	}
		
		@RequestMapping("/update")
		public String update() {
			
			
			
			return"update";
			
		}
		
		
		@RequestMapping("/updateEmployee")
		public String updateEmployee(Employee u,HttpServletRequest req, HttpServletResponse res) {
			
			HttpSession session=req.getSession();
			session.setAttribute("updateEmployee", u);
			
			
			
			return "update";
			
			
		}
			
		
		@RequestMapping("/updateEmployeeData")
		public String updateEmployeeData(Employee e) {
		    Optional<Employee> op = er.findById(e.getId());
		    if (op.isPresent()) {
		        Employee e1 = op.get();
		        e1.setName(e.getName());
		        e1.setCity(e.getCity());
		        e1.setGender(e.getGender());
		        e1.setAddress(e.getAddress());
		        e1.setPassword(e.getPassword());
		        e1.setEmail(e.getEmail());
		        er.save(e1);
		    } else {
		        System.out.println("Employee not found with ID: " + e.getId());
		    }
		    return "redirect:/home";
		}


		
		@RequestMapping("/login")
		public String login() {
			return "login";
		
		}
		
		@RequestMapping("/checklogin")
		
		public String checklogin (Employee e, HttpServletRequest req, HttpServletResponse res) {
			
			List<Employee>list=(List) er.findAll();
			
			for(Employee e1 : list) {
				
			
				
				if(e.getEmail().equals(e1.getEmail()) ){
					
					System.out.println(e1.getName());
					
					HttpSession session = req.getSession();
					session.setAttribute("loginname", e1.getName());
				
			return "redirect:/home";
				}
			
}
			return "login";
		}
			
			@RequestMapping("/logout")
			
			public String logout(HttpServletRequest req, HttpServletResponse res) {
			
			
			HttpSession session = req.getSession();
			session.removeAttribute("loginname");
		
            return "redirect:/home";
		
}
}

	


	
