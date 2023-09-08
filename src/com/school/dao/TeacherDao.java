package com.school.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.school.configuration.HelperClass;

import com.school.dto.Teacher;

public class TeacherDao {
	
   HelperClass helperClass=new HelperClass();
	Connection connection=null;
	
	
	//To retrieve multiple user's data
		public Teacher getAllTeacherData(Teacher teacher) {
			
			connection=helperClass.getConnection();
		
			String sql="SELECT * FROM teacher";
			
		
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
//			if(student!=null) {
//				return true;
//			}else {
//				return false;
//			}
			
			return teacher;
	}
		
		
		
		//To retrieve data of single user 
		public boolean  getTeacherDataById(int teacher_id) {
			
			connection= helperClass.getConnection();
	       
			String sql="SELECT * FROM teacher WHERE teacher_id=?";
			
			try {
				PreparedStatement preparedStatement=connection.prepareStatement(sql);
				
				preparedStatement.setInt(1, teacher_id);
				
				
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
			
			if (teacher_id>0) {
				return true;
			} else {
				return false;

			}
			
		}
		
		
		
		//To update the data
		public boolean updateTeacherById(int teacher_id) {
			connection=helperClass.getConnection();
			String sql="UPDATE teacher SET teacher_name='dummy4',teacher_email='dummy4@mail.com' WHERE teacher_id=?";
			int i=0;
			
			
			try {
				PreparedStatement preparedStatement=connection.prepareStatement(sql);
				
				preparedStatement.setInt(1, teacher_id);
				
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
		
		
		
		
		//to delete the teacher data
		
		public boolean deleteTeacherById(int teacher_id) {
			connection=helperClass.getConnection();
			String sql="DELETE FROM teacher WHERE teacher_id=?";
			int i=0; 
			
			
			
			try {
				PreparedStatement preparedStatement=connection.prepareStatement(sql);
				
				preparedStatement.setInt(1, teacher_id);
				
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
		
	
	public Teacher saveTeacher(Teacher teacher) {
		connection=helperClass.getConnection();
		String sql="INSERT INTO teacher VALUES(?,?,?)";
		
		try {
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			
			preparedStatement.setInt(1, teacher.getTeacher_id());
			preparedStatement.setString(2, teacher.getTeacher_name());
			preparedStatement.setString(3, teacher.getTeacher_email());
			
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
		
		
		
		return teacher;
	}
	
	
}
