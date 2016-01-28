package src;

public class Movie {

	private String movieName;
	private int price;
	private String time;

	public Movie(String movieName, String time, int price) {

		this.movieName = movieName;
		this.time = time;
		this.price = price;
	}

	public String getMovieTime() {
		
		return this.time;
	}

	public String getName() {
		
		return this.movieName;
	}

	public int getPrice() {
		
		return this.price;
	}
}
