package com.school.controller;




import com.school.dto.Student;
import com.school.service.StudentService;

public class TestSave {
	
	
	
	public static void main(String[] args) {
		Student student=new Student();
		
		
		StudentService studentService=new StudentService();
		
		
		boolean s=studentService.getStudentDataById(3);
		System.out.println(s);
		
		Student s1=studentService.getAllStudentData(student);
		System.out.println(s1);
	

      
       boolean res1=studentService.updateStudentById(4);
       System.out.println(res1);
		
		
		
		boolean res=studentService.deleteStudentById(2);
		System.out.println(res);
		
		
	
		
	}

}
