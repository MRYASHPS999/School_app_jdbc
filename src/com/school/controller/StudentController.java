package com.school.controller;

import com.school.dto.Student;
import com.school.service.StudentService;

public class StudentController {
	
	public static void main(String[] args) {
		
		Student student=new Student();
		
		student.setId(7);
		student.setName("dude2");
		student.setEmail("dude2@mail.com");
		
//		System.out.println("Enter id:");
//		int id=student.setId();
		
		StudentService studentService=new StudentService();
		
		Student s=studentService.saveStudent(student);
		
		if(s!=null) {
			System.out.println(s.getId()+ " saved succesfully");
		}
		
	}

}
