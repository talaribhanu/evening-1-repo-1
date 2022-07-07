package com.learn.springboot;


import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import com.learn.springboot.service.StudentService;

@SpringBootApplication
public class SpringFirstProject2Application implements CommandLineRunner {
	
	@Autowired
	StudentService studentservice;
	
	@Autowired
	EntityManager entitymanager;
	
	/*@Autowired
	BookRepo bookrepo;*/

	public static void main(String[] args) {
		SpringApplication.run(SpringFirstProject2Application.class, args);
		
	
		
		
		
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		List<Student> students = studentservice.getAllStudents();
		for(Student temp: students)
		{
			System.out.println("--------");
			System.out.println("Id :" + temp.getId());
			System.out.println("Age :" + temp.getAge());
			System.out.println("Name :" + temp.getFirstName() + temp.getLastName());
		}
		 
		  /*  //one to one
		
			Passport passport = entitymanager.find(Passport.class, 1);
			System.out.println(passport.getNumber());
			System.out.println(passport.getStudent().getFirstName());
			
			// Reverse one to one
			
			System.out.println("*** Reverse one to one ***");
			Student student = entitymanager.find(Student.class,2);
			System.out.println(student.getFirstName());
			System.out.println(student.getPassport().getNumber());
			*/
			
			//Many to One
			/*Review review = entitymanager.find(Review.class,1);
			System.out.println(review.getMessage());*/
		
		//MongoDB
		
		/*Book myBook = Book.builder().id(1).name("book1").author("author1").build();
		bookrepo.save(myBook);// insert into database*/
			
		
	}

}
