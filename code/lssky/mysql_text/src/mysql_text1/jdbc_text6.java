package mysql_text1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class jdbc_text6 {

	public static void main(String[] args) {
		loadDriverClass();
		Connection conn=getconnection();
		Statement stmt=createStatement(conn);
		String sql="delete from emp where ename='ls'";
		try {
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		close(conn,stmt);
	}
	public static void loadDriverClass() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	public static Connection getconnection() {
		Connection conn=null;
		String url="jdbc:mysql://localhost:3306/ls?useSSL=false";
		String user="root";
		String password="root";
		try {
			conn = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	public static Statement createStatement( Connection conn) {
		Statement stmt=null;
		try {
			stmt=conn.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return stmt;
	}
	public static void close(Connection conn,Statement stmt) {
		if(null!=stmt) {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(null!=conn) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		}

}

