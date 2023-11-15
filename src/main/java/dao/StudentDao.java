package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import helper.MyHelper;
import models.StudentRegistration;

public class StudentDao {
	public int createStudentRegistration(StudentRegistration srs) {
		
		int status=0;
		String query="insert into studentregistration(name,date,gender,phone,education,attend,photo) values(?,?,?,?,?,?,?)";
		Connection con=MyHelper.getInstance().getConnection();
		try {
			
			PreparedStatement ps=con.prepareStatement(query);
			
			ps.setString(1, srs.getName());
			ps.setString(2, srs.getDate());
			ps.setString(3, srs.getGender());
			ps.setString(4, srs.getPhone());
			ps.setString(5, srs.getEducation());
			ps.setString(6, srs.getAttend());
			ps.setString(7, srs.getPhoto());
			status =ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} 
		return status;
	}

	public List<StudentRegistration> allStudentUser() {
		List<StudentRegistration> srs=new ArrayList<StudentRegistration>();
		String query="select * from studentregistration";
		Connection con=MyHelper.getInstance().getConnection();
		try {
			PreparedStatement ps=con.prepareStatement(query);
			
			ResultSet rs=ps.executeQuery();
			while (rs.next()) {
				StudentRegistration sr = new StudentRegistration();
					sr.setStudentId(rs.getInt("studentId"));
					sr.setName(rs.getString("name"));
					sr.setDate(rs.getString("date"));
					sr.setGender(rs.getString("gender"));
					sr.setPhone(rs.getString("phone"));
					sr.setEducation(rs.getString("education"));
					sr.setAttend(rs.getString("attend"));
					sr.setPhoto(rs.getString("photo"));
				srs.add(sr);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return srs;

	    }
	public List<StudentRegistration> studentById(int studentId){ 
		
			List<StudentRegistration> srs=new ArrayList<StudentRegistration>();
			String query="select * from studentregistration where studentId=?";
			Connection con=MyHelper.getInstance().getConnection();
			try {
				PreparedStatement ps=con.prepareStatement(query);
				ps.setInt(1, studentId);
				ResultSet rs=ps.executeQuery();
				while (rs.next()) {
					StudentRegistration sr = new StudentRegistration();
					sr.setStudentId(rs.getInt("studentId"));
					sr.setName(rs.getString("name"));
					sr.setDate(rs.getString("date"));
					sr.setGender(rs.getString("gender"));
					sr.setPhone(rs.getString("phone"));
					sr.setEducation(rs.getString("education"));
					sr.setAttend(rs.getString("attend"));
					sr.setPhoto(rs.getString("photo"));
					srs.add(sr);
				}
			} catch (SQLException e) {
				System.out.println(e.getMessage());
				e.printStackTrace();
			}
			return srs;
		}
public List<StudentRegistration> studentAttend(String attend){ 
		
		List<StudentRegistration> srs=new ArrayList<StudentRegistration>();
		String query="select * from studentregistration where attend like ?";
		Connection con=MyHelper.getInstance().getConnection();
		try {
			PreparedStatement ps=con.prepareStatement(query);
			
		     ps.setString(1,"%"+ attend +"%");
			ResultSet rs=ps.executeQuery();
			while (rs.next()) {
				StudentRegistration sr = new StudentRegistration();

				sr.setStudentId(rs.getInt("studentId"));
				sr.setName(rs.getString("name"));
				sr.setDate(rs.getString("date"));
				sr.setGender(rs.getString("gender"));
				sr.setPhone(rs.getString("phone"));
				sr.setEducation(rs.getString("education"));
				sr.setAttend(rs.getString("attend"));
				sr.setPhoto(rs.getString("photo"));
				srs.add(sr);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return srs;
	}
public List<StudentRegistration> studentName(String name){ 
	
	List<StudentRegistration> srs=new ArrayList<StudentRegistration>();
	String query="select * from studentregistration where name like ?";
	Connection con=MyHelper.getInstance().getConnection();
	try {
		PreparedStatement ps=con.prepareStatement(query);
		
	     ps.setString(1,"%"+ name +"%");
		ResultSet rs=ps.executeQuery();
		while (rs.next()) {
			StudentRegistration sr = new StudentRegistration();

			sr.setStudentId(rs.getInt("studentId"));
			sr.setName(rs.getString("name"));
			sr.setDate(rs.getString("date"));
			sr.setGender(rs.getString("gender"));
			sr.setPhone(rs.getString("phone"));
			sr.setEducation(rs.getString("education"));
			sr.setAttend(rs.getString("attend"));
			sr.setPhoto(rs.getString("photo"));
			srs.add(sr);
		}
	} catch (SQLException e) {
		System.out.println(e.getMessage());
		e.printStackTrace();
	}
	return srs;
}
	public List<StudentRegistration> studentMore(String studentId,String name,String attend){ 
		
		List<StudentRegistration> srs=new ArrayList<StudentRegistration>();
		String query="select * from studentregistration where studentId=? or name=? or attend=?";
		Connection con=MyHelper.getInstance().getConnection();
		try {
			PreparedStatement ps=con.prepareStatement(query);
			ps.setString(1, studentId);
			 ps.setString(2, name );
		     ps.setString(3, attend);
			ResultSet rs=ps.executeQuery();
			while (rs.next()) {
				StudentRegistration sr = new StudentRegistration();

				sr.setStudentId(rs.getInt("studentId"));
				sr.setName(rs.getString("name"));
				sr.setDate(rs.getString("date"));
				sr.setGender(rs.getString("gender"));
				sr.setPhone(rs.getString("phone"));
				sr.setEducation(rs.getString("education"));
				sr.setAttend(rs.getString("attend"));
				sr.setPhoto(rs.getString("photo"));
				srs.add(sr);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return srs;
	}

		
	public int studentDelete(int studentId){
		int status=0;
		String query="delete from studentregistration where studentId=?";
		Connection con=MyHelper.getInstance().getConnection();
		try {
			PreparedStatement ps=con.prepareStatement(query);
			ps.setInt(1, studentId);
			status=ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return status;
	}
	public int updateStudentRegistration(StudentRegistration srs) {
		int status=0;
		String query="update studentregistration set name=?,date=?,gender=?,phone=?,education=?,attend=?,photo=? where studentId=?";
		Connection con=MyHelper.getInstance().getConnection();
		try {
			PreparedStatement ps=con.prepareStatement(query);
			
			ps.setString(1, srs.getName());
			ps.setString(2, srs.getDate());
			ps.setString(3, srs.getGender());
			ps.setString(4, srs.getPhone());
			ps.setString(5, srs.getEducation());
			ps.setString(6, srs.getAttend());
			ps.setString(7, srs.getPhoto());
			ps.setInt(8, srs.getStudentId());
			status=ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e);
			e.printStackTrace();
		}
		return status;
	}


}
