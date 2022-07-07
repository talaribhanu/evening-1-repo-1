package com.learn.springboot;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor


public class Review {
	@Id
	private int id;
	private String message;
	
	@ManyToOne
	private Course course;

}
