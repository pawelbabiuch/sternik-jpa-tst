package main.java;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;

public class dbAccess {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Connection conn = null;
		
		try {
			Class.forName("org.h2.Driver");
			String db = "jdbc:h2:~/test";
			
			conn = DriverManager.getConnection(db, "sa", "sa");
			
			getRowsFromArticle(conn);
			
		}catch(SQLException el) {
			
		}finally {
			
			if(conn != null)
				conn.close();
		}
		
		
	}
	
	private static void getRowsFromArticle(Connection conn) throws SQLException {
		
		Statement st = conn.createStatement();
		ResultSet res = st.executeQuery("SELECT * FROM ARTICLE");
		
		System.out.println("Wypisywanie");
		
		while(res.next()) {
			int id = res.getInt(1);
			String name = res.getString(2);
			String desc = res.getString(3);
			
			System.out.println(id + ". " + name + " " + desc);
		}
		
		st.close();
	}

}
