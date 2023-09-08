package com.school.dao;

import java.sql.Connection;
//import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.school.configuration.HelperClass;
import com.school.dto.Student;

public class StudentDao {
	
	HelperClass helperClass=new HelperClass();
	Connection connection=null;
	
	//To retrieve multiple user's data
	public Student getAllStudentData(Student student) {
		
		connection=helperClass.getConnection();
	
		String sql="SELECT * FROM student";
		
	
		try {
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			
		
			
			ResultSet resultSet=preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				System.out.println(resultSet.getInt(1));
				System.out.println(resultSet.getString(2));
				System.out.println(resultSet.getString(3));
				System.out.println("=========================================================");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
//		
//		if(student!=null) {
//			return true;
//		}else {
//			return false;
//		}
		
		return student;
}
	
	
	
	//To retrieve data of single user 
	public boolean  getStudentDataById(int id) {
		
		connection= helperClass.getConnection();
       
		String sql="SELECT * FROM student WHERE id=?";
		
		try {
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			
			preparedStatement.setInt(1, id);
			
			
			ResultSet resultSet= preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				System.out.println(resultSet.getInt(1));
				System.out.println(resultSet.getString(2));
				System.out.println(resultSet.getString(3));
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if (id>0) {
			return true;
		} else {
			return false;

		}
		
	}
	
	
	
	//To update the data
	public boolean updateStudentById(int id) {
		connection=helperClass.getConnection();
		String sql="UPDATE student SET name='dummy4',email='dummy4@mail.com' WHERE id=?";
		int i=0;
		
		
		try {
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			
			preparedStatement.setInt(1, id);
			
			i=preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if(i>0) {
			return true;
		}else {
			return false;
		}
	}
	
	
	
	
	//to delete the student data
	
	public boolean deleteStudentById(int id) {
		connection=helperClass.getConnection();
		String sql="DELETE FROM student WHERE id=?";
		int i=0; 
		
		
		
		try {
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			
			preparedStatement.setInt(1, id);
			
			 i=preparedStatement.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if(i>0) {
			return true;
		}else {
			return false;
		}
		
	}
	
	
	
	
	
	//To save a student data
	public Student saveStudent(Student student) {
		
		connection=helperClass.getConnection();
		String sql="INSERT INTO student VALUES(?,?,?)";
		
		 try {
			 //create statement
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			
			//passed the values to delimiters/placeholders --> ?
			preparedStatement.setInt(1, student.getId());
			preparedStatement.setString(2, student.getName());
			preparedStatement.setString(3, student.getEmail());
			
			//execute
			preparedStatement.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		 
		 return student;
	}
}
