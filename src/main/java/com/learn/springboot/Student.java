package com.learn.springboot;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Student {
	@Id
	@NonNull
	private int id;
	
	private int age;
	
	private String firstName;
	private String lastName;
	
	/*@OneToOne(mappedBy = "student")
	
	private Passport passport;*/
	
	
	
}