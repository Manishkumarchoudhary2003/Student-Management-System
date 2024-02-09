package com.manish.springboot.myfirstwebapp.student;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;

@Entity
public class Student {

	@Id
	@GeneratedValue
	private int id;

	@Min(value = 1, message = "Roll no should be at least 1")
	@Max(value = 50, message = "Roll no should be less than or equal to 50")
	private int rollno;
	
	@Size(min = 6, message = "Name should be at least 6 characters")
	private String name;
	
	private String classname;

	@Min(value = 0, message = "Marks should be at least 0")
	@Max(value = 100, message = "Marks should be less than or equal to 100")
	private int marks1;

	@Min(value = 0, message = "Marks should be at least 0")
	@Max(value = 100, message = "Marks should be less than or equal to 100")
	private int marks2;

	@Min(value = 0, message = "Marks should be at least 0")
	@Max(value = 100, message = "Marks should be less than or equal to 100")
	private int marks3;

	private float percentage;
	private String result;

	public Student() {

	}

	public Student(int id, int rollno, String name, String classname, int marks1, int marks2, int marks3,
			float percentage, String result) {
		super();
		this.id = id;
		this.rollno = rollno;
		this.name = name;
		this.classname = classname;
		this.marks1 = marks1;
		this.marks2 = marks2;
		this.marks3 = marks3;
		this.percentage = percentage;
		this.result = result;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getRollno() {
		return rollno;
	}

	public void setRollno(int rollno) {
		this.rollno = rollno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getClassname() {
		return classname;
	}

	public void setClassname(String classname) {
		this.classname = classname;
	}

	public int getMarks1() {
		return marks1;
	}

	public void setMarks1(int marks1) {
		this.marks1 = marks1;
	}

	public int getMarks2() {
		return marks2;
	}

	public void setMarks2(int marks2) {
		this.marks2 = marks2;
	}

	public int getMarks3() {
		return marks3;
	}

	public void setMarks3(int marks3) {
		this.marks3 = marks3;
	}

	public float getPercentage() {
		return percentage;
	}

	public void setPercentage(float percentage) {
		this.percentage = percentage;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", rollno=" + rollno + ", name=" + name + ", classname=" + classname + ", marks1="
				+ marks1 + ", marks2=" + marks2 + ", marks3=" + marks3 + ", percentage=" + percentage + ", result="
				+ result + "]";
	}

}
