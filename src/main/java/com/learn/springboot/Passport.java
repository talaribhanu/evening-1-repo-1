package com.learn.springboot;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Passport {
	
	@Id
	private int id;
	private String number;
	
	/*@OneToOne
	
	private Student student;
	*/
	
	

}
