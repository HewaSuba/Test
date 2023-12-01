package DbPro;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.*;

public class DtabasePrictise {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection conn  = null;
		Statement stat  = null;
		ResultSet rs = null;
		
		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
		} catch (ClassNotFoundException e) {
			System.out.println("problem in loading the driver");
			e.printStackTrace();
		}
		
		try {
			String dbName = "dbPro.accdb";
			String dbURL = "jdbc:ucanaccess://" + dbName;
			conn = DriverManager.getConnection(dbURL);
			stat = conn.createStatement();
			String n = "supun";
			double sa = 450.89;
			String query = "INSERT INTO Emp (EName,Salary) values ('"+n+"', "+sa+")";
			stat.executeUpdate(query);
			
			
			query = "UPDATE Emp SET  Salary = 1200 WHERE EName = 'ABC'";
			
			stat.executeUpdate(query);
			rs = stat.executeQuery("Select * from Emp");
			
			stat.executeUpdate(query);
			
			
			int id;
			String name;
			double sal;
			
			while (rs.next()) {
				id = rs.getInt(1);
				name = rs.getString(2);
				sal = rs.getDouble(3);
				System.out.println("Id " + id + " Name " + name + " Salary " + sal);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		finally {
			try {
				if(conn !=null) {
					rs.close();
					stat.close();
					conn.close();
				}
				
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}
		

	}

}
