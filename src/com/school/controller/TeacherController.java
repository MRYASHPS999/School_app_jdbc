package com.school.controller;

import com.school.dto.Teacher;
import com.school.service.TeacherService;

public class TeacherController {
	
	
public static void main(String[] args) {
	
	Teacher teacher=new Teacher();
	
	teacher.setTeacher_id(2);
	teacher.setTeacher_name("t2");
	teacher.setTeacher_email("t2@mail.com");
	
	
	TeacherService teacherService=new TeacherService();
	
	Teacher t= teacherService.saveTeacher(teacher);
	
	if(t!=null) {
		System.out.println("Teacher data for " + teacher.getTeacher_id() + " saved successfully");
	}
	
	
	
}
}
