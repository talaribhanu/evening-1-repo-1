package com.learn.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learn.springboot.Student;
import com.learn.springboot.repository.StudentRepository;

@Service
public class StudentService {
	
	@Autowired
	StudentRepository repository;

	public List<Student> getAllStudents()
	{
		return repository.findAll();
	}
	
	public void addStudent(Student student)
	{
		repository.save(student);
	}
	public void deleteStudent(Student student)
	{
		repository.delete(student);
	}
}
