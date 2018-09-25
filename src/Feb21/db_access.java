package Feb21;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;


public class db_access {

	public static void main(String[] args){
	
	     try {
	            // The newInstance() call is a work around for some
	            // broken Java implementations

	            Class.forName("com.mysql.jdbc.Driver").newInstance();
	        } catch (Exception ex) {
	            // handle the error
	        }
		Connection conn = null;
	
		try {
			conn =
				DriverManager.getConnection("jdbc:mysql://localhost/H_O_T_S?" +
	                                   "user=root&password=h5t6y5");
	    // Do something with the Connection

		} catch (SQLException ex) {
			// handle any errors
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		}
	
		Statement stmt = null;
		ResultSet rs = null;
		
		//System.out.println("Querying Student Table");
	
		try {
			
			stmt = conn.createStatement();
		    rs = stmt.executeQuery("SELECT foo FROM bar");
	
		    // or alternatively, if you don't know ahead of time that
		    // the query will be a SELECT...
	
		    if (stmt.execute("SELECT foo FROM bar")) {
		        rs = stmt.getResultSet();
		    }
	
		    // Now do something with the ResultSet ....
		}
		catch (SQLException ex){
		    // handle any errors
		    System.out.println("SQLException: " + ex.getMessage());
		    System.out.println("SQLState: " + ex.getSQLState());
		    System.out.println("VendorError: " + ex.getErrorCode());
		}
		finally {
		    // it is a good idea to release
		    // resources in a finally{} block
		    // in reverse-order of their creation
		    // if they are no-longer needed
	
		    if (rs != null) {
		        try {
		            rs.close();
		        } catch (SQLException sqlEx) { } // ignore
	
		        rs = null;
		    }
	
		    if (stmt != null) {
		        try {
		            stmt.close();
		        } catch (SQLException sqlEx) { } // ignore
	
		        stmt = null;
		    	}
			}
		}
}
