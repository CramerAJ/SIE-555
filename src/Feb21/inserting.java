package Feb21;
//Andrew Cramer
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class inserting {
	
	public static void main(String[] args){
		
	/*	String Fname_actor_one = "Keanu";
		String Lname_actor_one = "Reeves";
		
		String Fname_actor_two = "Ryan";
		String Lname_actor_two = "Gosling";
		
		String Gndr_actor_one = "M";
		String Gndr_actor_two = "M";
		
		String movie_actor_one = "John Wick 2";
		String movie_actor_two = "La La Land";
		
		String Cname_actor_one = "John Wick";
		String Cname_actor_two = "Sebastian";
		
		String Ctype_actor_one = "Assassin";
		String Ctype_actor_two = "protagonist";
		*/
		
	     try {
	            // The newInstance() call is a work around for some
	            // broken Java implementations

	            Class.forName("com.mysql.jdbc.Driver").newInstance();
	            
	        } 
	     catch (Exception ex) {
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
			
			stmt = conn.createStatement();
			stmt.executeUpdate("INSERT INTO `actor`(`Lastname`, `Firstname`, `Gender`)"
					+"VALUES ('CRAY','WUNDER','M')", Statement.RETURN_GENERATED_KEYS);
			rs = stmt.getGeneratedKeys();
			System.out.println("Intering into Actor Table");
			//This creates a new id holer and gets the next available id slot in the table
			int id = -1;
			if (rs.next()) {
				
		        id = rs.getInt(1);
			}
			stmt.executeUpdate("INSERT INTO `movie`(`movietitle`, `year`) VALUES ('John Wick','2017')",
					Statement.RETURN_GENERATED_KEYS);
			rs = stmt.getGeneratedKeys();
			//This creates a new id holer and gets the next available id slot in the table
			int movieid = -1;
			if (rs.next()) {
				
		        movieid = rs.getInt(1);
		    }
				
			stmt.executeUpdate("INSERT INTO `movie_role`(`a_id`, `m_id`, `character_name`, `character_type`) "
					+ "VALUES ('"+id+"','"+movieid+"','John Wick','Assassin')");
			
			System.out.println("Intering into Movie Table");
			System.out.println("Inserted into Move_Role");
			stmt.executeUpdate("INSERT INTO `actor`(`Lastname`, `Firstname`, `Gender`)"
					+"VALUES ('Ryan','Gosling','M')", Statement.RETURN_GENERATED_KEYS);
			rs = stmt.getGeneratedKeys();
			System.out.println("Intering into Actor Table");
			if (rs.next()) {
				
		        id = rs.getInt(1);
		    }

			stmt.executeUpdate("INSERT INTO `movie`(`movietitle`, `year`) VALUES ('La La Land','2017')",
					Statement.RETURN_GENERATED_KEYS);			

			System.out.println("Intering into Movie Table");

			rs = stmt.getGeneratedKeys();
			if (rs.next()) {
				
		        movieid = rs.getInt(1);
		    }

			stmt.executeUpdate("INSERT INTO `movie_role`(`a_id`, `m_id`, `character_name`, `character_type`) "
					+ "VALUES ('"+id+"','"+movieid+"','Sebastian','protagonist')");
			System.out.println("Intering into Movie Role Table");
			
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
