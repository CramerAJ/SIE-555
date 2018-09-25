//Andrew Cramer
package Feb21;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class part2 {
	
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
			//gets the data from the database
			stmt = conn.createStatement();
		    rs = stmt.executeQuery("SELECT A.Firstname, A.Lastname,M.movietitle, M.year, C.character_name FROM `actor` A ,`movie` M ,`movie_role`C "
		    		+ "Where A.a_id = C.a_id AND M.m_id = C.m_id");
		    System.out.println("Output of all Tables via a single SQL Query");
		   //while loop outputs all the names and variables
		    while (rs.next()){
		    	System.out.println("");
		    	System.out.print(rs.getString("Firstname"));
		    	System.out.print("-|-");
		    	System.out.print(rs.getString("Lastname"));
		    	System.out.print("-|-");
		    	System.out.print(rs.getString("movietitle"));
		    	System.out.print("-|-");
		    	System.out.print(rs.getString("character_name"));
		    	System.out.print("-|-");
		    	System.out.print(rs.getString("year"));
		    	System.out.println(" ");
		    	System.out.println("---------------------------------------------------------------");
		    }
		    
		    /*	    if (stmt.execute("SELECT foo FROM bar")) {
		        rs = stmt.getResultSet();
		    }
	*/
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
