package com.learn.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learn.springboot.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

}
