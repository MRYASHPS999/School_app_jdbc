package com.school.service;

import com.school.dao.StudentDao;
import com.school.dto.Student;

public class StudentService {
	
	StudentDao studentDao=new StudentDao();
	
	public Student getAllStudentData(Student student) {
		 return studentDao.getAllStudentData(student);
	}
	
	public boolean getStudentDataById(int id) {
		return studentDao.getStudentDataById(id);
	}
	
	public boolean updateStudentById(int id) {
		return studentDao.updateStudentById(id);
	}
	
	public boolean deleteStudentById(int id) {
		return studentDao.deleteStudentById(id);
	}
	
	public Student saveStudent(Student student) {
		
		//return studentDao.saveStudent(student);
		Student s=studentDao.saveStudent(student);
		return s;
	}

}
