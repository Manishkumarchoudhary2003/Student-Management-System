package com.manish.springboot.myfirstwebapp.student;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository  extends JpaRepository<Student, Integer>{
	
	public List<Student> findByClassname(String classname);

}
