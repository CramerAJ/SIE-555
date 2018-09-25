//Andrew Cramer
package Feb21;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class counter {

	public static void main(String[] args) {
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
				DriverManager.getConnection("jdbc:mysql://localhost:8889/SIE555-2017?" +
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
			System.out.println("Counting Time");
			stmt = conn.createStatement();
	
		    rs = stmt.executeQuery("SELECT A.Lastname, COUNT(M.a_id) FROM `actor` A, `movie_role` M WHERE A.a_id = M.a_id GROUP BY M.a_id ");
		    System.out.println("Selecting the contents");
		    
		    while (rs.next()){
		    	String lname = rs.getString("A.Lastname");
		    	String a_id = rs.getString("COUNT(M.a_id)");
		    	System.out.println("|"+lname+"|"+a_id+"|");
		    }
		}
		catch (SQLException ex){
		    // handle any errors
		    System.out.println("SQLException: " + ex.getMessage());
		    System.out.println("SQLState: " + ex.getSQLState());
		    System.out.println("VendorError: " + ex.getErrorCode());
		}
		finally {
	
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
