package H_O_T_S;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;


public class Inserting {

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
				DriverManager.getConnection("jdbc:mysql://localhost:8889/H_O_T_S?" +
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
			Scanner scan = new Scanner(System.in);
			
			System.out.println("Enter the Hero Name: ");
			String Name = scan.nextLine();
			
			System.out.println("Role: ");
			String Role = scan.nextLine();
			
			System.out.println("Which Hero is the Game From: ");
			String Game = scan.nextLine();
			
			System.out.println("Base_HP: ");
			int base_hp = scan.nextInt();
			
			System.out.println("Base_DMG: ");
			int base_dmg = scan.nextInt(); 
			
			System.out.println("Base_SPEED: ");
			float base_speed = scan.nextFloat();
			
			System.out.println("Base Q DMG: ");
			int Q_dmg = scan.nextInt();
			
			System.out.println("Base W DMG: ");
			int W_dmg = scan.nextInt();
			
			System.out.println("Base E DMG: ");
			int E_dmg = scan.nextInt();
			
			System.out.println("Base R1 DMG: ");
			int R1_dmg = scan.nextInt();
			
			System.out.println("Base R2 DMG: ");
			int R2_dmg = scan.nextInt();
			
			System.out.println("Base Q HEAL: ");
			int Q_hl = scan.nextInt();
			
			System.out.println("Base W HEAL: ");
			int W_hl = scan.nextInt();
			
			System.out.println("Base E HEAL: ");
			int E_hl = scan.nextInt();
			
			System.out.println("Base R1 HEAL: ");
			int R1_hl = scan.nextInt();
			
			System.out.println("Base R2 HEAL: ");
			int R2_hl = scan.nextInt();
			
			stmt = conn.createStatement();
			stmt.executeUpdate("INSERT INTO `Hero`(`Name`,`Role`, `Game`, `Base_HP`, `Base_DMG`, `Base_SPEED`)"
					+ " VALUES ('"+Name+"',"
							+ "'"+Game+"',"
							+ "'"+Role+"',"
							+ "'"+base_hp+"',"
							+ "'"+base_dmg+"',"
							+ "'"+base_speed+"'"+
							")", Statement.RETURN_GENERATED_KEYS);
			rs = stmt.getGeneratedKeys();
			System.out.println("Inserted into Hero Table");
			
			int hero_id = -1;
			if (rs.next()) {
				
		        hero_id = rs.getInt(1);
			}
			
			stmt.executeUpdate("INSERT INTO `Abilities_Damage`(`Q`, `W`, `E`, `R1`, `R2`)"
					+ " VALUES ('"+Q_dmg+"',"
							 + "'"+W_dmg+"',"
							 + "'"+E_dmg+"',"
							 + "'"+R1_dmg+"',"
							 + "'"+R2_dmg+"')",
					Statement.RETURN_GENERATED_KEYS);
			rs = stmt.getGeneratedKeys();
			//This creates a new id holer and gets the next available id slot in the table
			System.out.println("Inserted into AbilityDMG Table");
			int ability_id = -1;
			if (rs.next()) {
				
		        ability_id = rs.getInt(1);
		    }

			stmt.executeUpdate("INSERT INTO `Abilities_Healing`( `Q`, `W`, `E`, `R1`, `R2`)"
					+ " VALUES ('"+Q_hl+"',"
							 + "'"+W_hl+"',"
							 + "'"+E_hl+"',"
							 + "'"+R1_hl+"',"
							 + "'"+R2_hl+"')",
					Statement.RETURN_GENERATED_KEYS);
			int abil_id = -1;
			if (rs.next()) {
				
		        abil_id = rs.getInt(1);
		    }
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
