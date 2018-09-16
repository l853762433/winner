package mysql_text1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class jdbc_text2 {

	public static void main(String[] args) {
		loadDriverClass();
		String url="jdbc:mysql://localhost:3306/ls?useSSL=false";
		String user="root";
		String password="root";
		Connection conn=getconnection(url, user,password);
		Statement stmt=createStatement(conn);
		String sql="select * from ls.emp";
		ResultSet rs =executeQuery(stmt, sql);
		try {
			while (rs.next()) {
				System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getInt(4)+" "+
						rs.getDate(5)+" "+rs.getDouble(6)+" "+rs.getDouble(7)+" "+rs.getInt(8));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		close( conn, stmt, rs);
	}
	public static Connection getconnection(String url,String user,String password) {
			Connection conn;
			try {
				conn = DriverManager.getConnection(url, user, password);
			} catch (SQLException e) {
				e.printStackTrace();
				throw new RuntimeException(e);
			}
			return conn;
	}
	public static void loadDriverClass() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	public static Statement createStatement( Connection conn) {
		Statement stmt;
		try {
			stmt=conn.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		return stmt;
	}
	public static  ResultSet executeQuery(Statement stmt,String sql) {
		ResultSet rs;
		try {
			rs=stmt.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		return rs;
	}
	public static void close(Connection conn,Statement stmt,ResultSet rs) {
	if(null!=rs) {
		try {
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
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
