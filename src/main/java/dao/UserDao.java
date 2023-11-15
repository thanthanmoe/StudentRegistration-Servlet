package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import helper.MyHelper;
import models.UserRegistration;

public class UserDao {
	public int createUserRegistration(UserRegistration ur) {
		
		int status=0;
		String query="insert into userregistration(name,email,password,role) values(?,?,?,?)";
		Connection con=MyHelper.getInstance().getConnection();
		try {
			PreparedStatement ps=con.prepareStatement(query);
			
			ps.setString(1, ur.getName());
			ps.setString(2, ur.getEmail());
			ps.setString(3, ur.getPassword());
			ps.setString(4, ur.getRole());
			status =ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} 
		return status;
	}
			


	public int getUserDelete(String id){
		int status=0;
		String query="delete from userregistration where id=?";
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

	public int updateUserRegistration(UserRegistration user) {
		int status=0;
		String query="update userregistration set name=?,email=?,password=?,role=? where id=?";
		Connection con=MyHelper.getInstance().getConnection();
		try {
			PreparedStatement ps=con.prepareStatement(query);
			ps.setString(1, user.getName());
			ps.setString(2, user.getEmail());
			ps.setString(3, user.getPassword());
			ps.setString(4, user.getRole());
			ps.setInt(5, user.getId());
			status=ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e);
			e.printStackTrace();
		}
		return status;
	}

	public List<UserRegistration> getallUser() {
		List<UserRegistration> urs=new ArrayList<UserRegistration>();
		
		String query="select * from userregistration ";
		
		
		Connection con=MyHelper.getInstance().getConnection();
		try {
			PreparedStatement ps=con.prepareStatement(query);
			
			ResultSet rs=ps.executeQuery();
			while (rs.next()) {
				UserRegistration ur = new UserRegistration();
				ur.setId(rs.getInt("id"));
				ur.setName(rs.getString("name"));
				ur.setEmail(rs.getString("email"));
				ur.setPassword(rs.getString("password"));
				ur.setRole(rs.getString("role"));
				urs.add(ur);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return urs;

	    }

	public List<UserRegistration> userBy(String name){ 
		
		List<UserRegistration> urs=new ArrayList<UserRegistration>();
		String query="select * from userregistration where name=?";
		Connection con=MyHelper.getInstance().getConnection();
		try {
			PreparedStatement ps=con.prepareStatement(query);
			ps.setString(1, name);
			ResultSet rs=ps.executeQuery();
			while (rs.next()) {
				UserRegistration ur = new UserRegistration();
				ur.setId(rs.getInt("id"));
				ur.setName(rs.getString("name"));
				ur.setEmail(rs.getString("email"));
				ur.setPassword(rs.getString("password"));
				ur.setRole(rs.getString("role"));
				urs.add(ur);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return urs;
	}

	public List<UserRegistration> userId(String id){ 
		
		List<UserRegistration> urs=new ArrayList<UserRegistration>();
		String query="select * from userregistration where id=?";
		Connection con=MyHelper.getInstance().getConnection();
		try {
			PreparedStatement ps=con.prepareStatement(query);
			ps.setString(1, id);
			ResultSet rs=ps.executeQuery();
			while (rs.next()) {
				UserRegistration ur = new UserRegistration();
				ur.setId(rs.getInt("id"));
				ur.setName(rs.getString("name"));
				ur.setEmail(rs.getString("email"));
				ur.setPassword(rs.getString("password"));
				ur.setRole(rs.getString("role"));
				urs.add(ur);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return urs;
	}
	public List<UserRegistration> userByName(String id,String name){ 
		
		List<UserRegistration> urs=new ArrayList<UserRegistration>();
		String query="select * from userregistration where id=? or name like ?";
		Connection con=MyHelper.getInstance().getConnection();
		try {
			PreparedStatement ps=con.prepareStatement(query);
			ps.setString(1, id);
			ps.setString(2, "%"+ name +"%");
			ResultSet rs=ps.executeQuery();
			while (rs.next()) {
				UserRegistration ur = new UserRegistration();
				ur.setId(rs.getInt("id"));
				ur.setName(rs.getString("name"));
				ur.setEmail(rs.getString("email"));
				ur.setPassword(rs.getString("password"));
				ur.setRole(rs.getString("role"));
				urs.add(ur);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return urs;
	}


	}
