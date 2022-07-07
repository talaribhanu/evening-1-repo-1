package com.learn.springboot.controller;
import com.learn.springboot.Student;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.learn.springboot.Student;
import com.learn.springboot.service.StudentService;

@Controller
public class StudentController {
	@Autowired
	StudentService studentservice;
	
	@GetMapping("/getastudent")
	@ResponseBody
	public Student getStudent()
	
	{
		return Student.builder().age(19).firstName("Akshay").build();
	}
	
	@GetMapping("/list")
	
	public String listOfStudents(ModelMap map)
	{
		List<Student> students = studentservice.getAllStudents();
		
		map.addAttribute("message",students);
		return "list";
		
		
	}
	
	@GetMapping("/addstudent")
	
	public String addNewStudent(@RequestParam int id, @RequestParam int age, @RequestParam String firstname, @RequestParam String lastname, ModelMap model)
	{
		Student student = Student.builder().id(id).age(age).firstName(firstname).lastName(lastname).build();
		studentservice.addStudent(student);
		
		List<Student> students = studentservice.getAllStudents();
		
		model.addAttribute("message",students);
		return "list";
	}
	@GetMapping("/delete")
	public String deleteStudent(@RequestParam int id, ModelMap mode)
	{
		studentservice.deleteStudent(Student.builder().id(id).build());
		List<Student> students = studentservice.getAllStudents();
		
		mode.addAttribute("message",students);
		return "list";
		
	}
	
	

}
