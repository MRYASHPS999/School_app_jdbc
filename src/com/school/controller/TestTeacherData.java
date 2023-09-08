package com.school.controller;


import com.school.dto.Teacher;
import com.school.service.TeacherService;

public class TestTeacherData {

	public static void main(String[] args) {
		
		Teacher teacher=new Teacher();
		
		TeacherService teacherService=new TeacherService();
		
		boolean t=teacherService.getTeacherDataById(3);
		System.out.println(t);
		
		Teacher t1=teacherService.getAllTeacherData(teacher);
		System.out.println(t1);
	

      
       boolean res1=teacherService.updateTeacherById(4);
       System.out.println(res1);
		
		
		
		boolean res=teacherService.deleteTeacherById(2);
		System.out.println(res);

	}

}
