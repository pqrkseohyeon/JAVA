package com.exam01;

import java.io.Serializable;

public class Student implements Serializable {
	private String Name;
	private String department;
	private String id;
	private double grade;
	public Student(String name, String dept, String id, double grade) {
		this.Name = name;
		this.department=dept;
		this.id = id;
		this.grade = grade;
	}
	public String getName() {
		return Name;
	}
	public String getDepartment() {
		return department;
	}
	public String getId() {
		return id;
	}
	public double getGrade() {
		return grade;
	}

	

	

	


}
