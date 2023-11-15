package helper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class MyHelper {
	private final String DRIVER="com.mysql.jdbc.Driver";
	private final String URL="jdbc:mysql://localhost:3306/examproject";
	private final String USERNAME="root";
	private final String PASSWORD="rootroot";
	private Connection con;
	private static MyHelper helper;
	
	public MyHelper() {
		try {
			Class.forName(DRIVER);
			con=DriverManager.getConnection(URL,USERNAME,PASSWORD);
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e);
			e.printStackTrace();
		} catch (Exception e) {
			  throw new RuntimeException("uncaught", e);
		}
	}
	public static MyHelper getInstance() {
		if(helper==null) {
			helper=new MyHelper();
		}
		return helper;
	}
	public Connection getConnection() {
		return con;
	}
	
}
