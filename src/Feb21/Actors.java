package Feb21;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

	public class Actors {
		String Fname;
		String Lname;
		String Gndr;
	
	public Actors(String Fname,String Lname,String Gndr){
		this.Fname = Fname;
		this.Lname = Lname;
		this.Gndr = Gndr;
		
	}
	public String Insert (){
		return "INSERT INTO `actor`(`Lastname`, `Firstname`, `Gender`) "
				+ "VALUES ('"
				+ this.Lname + "','"
				+ this.Fname + "','"
				+ this.Gndr + "')";
	}
	
}
