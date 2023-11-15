package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import helper.MyHelper;
import models.CourseRegistration;



public class CourseDao {
	/* Start CourseRegistration */	
public int createCourse(CourseRegistration cr) {
	
	int status=0;
	String query="insert into courseregistration(course_name) values(?)";
	Connection con=MyHelper.getInstance().getConnection();
	try {
		PreparedStatement ps=con.prepareStatement(query);
	
		ps.setString(1, cr.getCourse_name());
		status =ps.executeUpdate();
	} catch (SQLException e) {
		System.out.println(e.getMessage());
		e.printStackTrace();
	} 
	return status;
}
public List<CourseRegistration> allCourse() {
	List<CourseRegistration> srs=new ArrayList<CourseRegistration>();
	String query="select * from courseregistration";
	Connection con=MyHelper.getInstance().getConnection();
	try {
		PreparedStatement ps=con.prepareStatement(query);
		
		ResultSet rs=ps.executeQuery();
		while (rs.next()) {
			CourseRegistration sr = new CourseRegistration();
				sr.setId(rs.getInt("id"));
				sr.setCourse_name(rs.getString("course_name"));
				
			srs.add(sr);
		}
	} catch (SQLException e) {
		System.out.println(e.getMessage());
		e.printStackTrace();
	}
	return srs;

    }


public int getCourseDelete(String id){
	int status=0;
	String query="delete from courseregistration where id=?";
	Connection con=MyHelper.getInstance().getConnection();
	try {
		PreparedStatement ps=con.prepareStatement(query);
		ps.setString(1, id);
		status=ps.executeUpdate();
	} catch (SQLException e) {
		System.out.println(e.getMessage());
		e.printStackTrace();
	}
	return status;
}

public int updateCourse(CourseRegistration course) {
	int status=0;
	String query="update courseregistration set course_name=? where id=?";
	Connection con=MyHelper.getInstance().getConnection();
	try {
		PreparedStatement ps=con.prepareStatement(query);
		ps.setString(1, course.getCourse_name());
		ps.setInt(2, course.getId());
		
		status=ps.executeUpdate();
	} catch (SQLException e) {
		System.out.println(e);
		e.printStackTrace();
	}
	return status;
}


}
