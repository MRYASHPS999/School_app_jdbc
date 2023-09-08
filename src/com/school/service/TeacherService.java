package com.school.service;


import com.school.dao.TeacherDao;

import com.school.dto.Teacher;

public class TeacherService {
	
	TeacherDao teacherDao=new TeacherDao();
	
	

	
	public Teacher getAllTeacherData(Teacher teacher) {
		 return teacherDao.getAllTeacherData(teacher);
	}
	
	public boolean getTeacherDataById(int teacher_id) {
		return teacherDao.getTeacherDataById(teacher_id);
	}
	
	public boolean updateTeacherById(int teacher_id) {
		return teacherDao.updateTeacherById(teacher_id);
	}
	
	public boolean deleteTeacherById(int teacher_id) {
		return teacherDao.deleteTeacherById(teacher_id);
	}
	
	
	public Teacher saveTeacher(Teacher teacher) {
		
	 Teacher t=teacherDao.saveTeacher(teacher);
	 
	 return t;
	}

}
  