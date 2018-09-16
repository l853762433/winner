package mysql_text1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class jdbc_text {

	public static void main(String[] args) {
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/ls?useSSL=false";
			String user="root";
			String password="root";
			conn = DriverManager.getConnection(url, user, password);
			System.out.println("get connection"+conn);
			stmt=conn.createStatement();
			rs=stmt.executeQuery("select * from ls.emp");
			while(rs.next()) {
				//int empno=rs.getInt("empno");
				//String ename=rs.getString("ename");
				//String job=rs.getString("job");
				//System.out.println("empno"+empno);
				//System.out.println("ename"+ename);
				//System.out.println("job"+job);
				System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getInt(4)+" "+
				rs.getDate(5)+" "+rs.getDouble(6)+" "+rs.getDouble(7)+" "+rs.getInt(8));
				
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if (stmt!=null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
		}
	}


