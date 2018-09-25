package Feb21;

public class Movies {
		String Movie ;
		String Year ;
		
	public Movies(String Movie,String Year){
			this.Movie = Movie;
			this.Year = Year;
			
		}
		
	public String Insert (){
		return "INSERT INTO `actor`(`Lastname`, `Firstname`, `Gender`) "
				+ "VALUES ('"
				+ this.Movie + "','"
				+ this.Year + "')";
	}
}

