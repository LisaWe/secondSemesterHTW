package src;

import java.util.ArrayList;
import java.util.Scanner;

public class Booking {

	static Scanner scan = new Scanner(System.in);
	private ArrayList<Movie> movieList;
	private ArrayList<Theater> theaters;
	private ArrayList<Seat> seats;
	private Movie movie;
	private Theater theater;

	public Booking(ArrayList<Movie> movieList, ArrayList<Theater> theaters) {
		
		this.seats = new ArrayList<>();
		this.movie = null;
		this.theater = null;
		this.movieList = movieList;
		this.theaters = theaters;
	}

	// Prints out the current booking for the customer, with all the required
	// informations.
	public void showBooking() {
		
		System.out.println();
		System.out.println("#####################################");
		System.out.println();
		System.out.println(this.movie.getName() + "- "
				+ this.movie.getMovieTime());
		System.out.println("Total seats : " + this.seats.size());
		System.out.println(("Total price :" + this.movie.getPrice()
				* this.seats.size())
				+ "€");
		System.out.println("Cinema hall: " + this.theater.getTheaterNumber());
		System.out.println();
		System.out.println("#####################################");
	}

	// Removes all of the current reserved seats and sets them "FREE" again.
	public void removeReservedSeats() {
		
		for (Seat seat : this.seats) {
			this.theater.unbookSeat(seat.getRow(), seat.getColumn());
		}
	}

	// Show the movie list, check the entered movie number and
	// get the theaters for each movie.
	// Prints out the seating plan for a selected theater.
	// Selecting n seats with its row and column. Every seat will be saved to
	// the ArrayList seats.
	public void getMovie() {
		
		System.out.println("Please select a movie from the list below by entering the movie number.\n");
		showMovieList();
		
		int movieNumber = scan.nextInt();

		while (movieNumber < 0 || movieNumber > this.movieList.size()) {
			System.out.println("Sorry! Select another number.");
			movieNumber = scan.nextInt();
		}

		this.movie = movieList.get(movieNumber - 1);
		String movieTitle = this.movie.getName().substring(3);
		String movieTime = this.movie.getMovieTime();
		
		System.out.println("Thanks, you selected the Movie " + movieTitle + ".\n");
		System.out.println("Please select the seats you would like to book.\n");

		if (movieTitle.equals("Avengers")) 
			this.theater = theaters.get(0);
		
		if (movieTitle.equals("Pulp Fiction")) 
			this.theater = theaters.get(1);
		
		if (movieTitle.equals("P.s. I love You")) 
			this.theater = theaters.get(2);
		
		if (movieTitle.equals("Resident Evil: The Final Chapter")) 
			this.theater = theaters.get(3);
		
		if (movieTitle.equals("The Hunger Games: Mockingjay")) 
			this.theater = theaters.get(4);
		
		if (movieTitle.equals("The Babadook")) 
			this.theater = theaters.get(5);

		this.theater.printSeatingPlan();
		System.out.println();
		System.out.println();
		System.out.println("Please select the row");
		
		// Checks the entered row. Neither a negative number nor a number above
		// four is allowed.
		int row = scan.nextInt();
		
		while (row > 4 || row < 0) {
			System.out.println("sorry, invalid number.");
			row = scan.nextInt();
		}
		
		System.out.println("Please select the column");
		
		// Checks the entered column. Neither a negative number nor a number
		// above eight is allowed.
		int column = scan.nextInt();

		while (column > 8 || column < 0) {
			System.out.println("sorry, invalid number.");
			column = scan.nextInt();
		}

		this.theater.bookSeat(row, column);
		this.seats.add(new Seat(row, column));
		System.out.println("Do you like to book another seat? Please type 'yes' or 'no'.");
		String answer = scan.next();

		if (answer.equals("yes")) {
			getMovie();
		} else {
			System.out.println("Thanks for your reservation. Here is your ticket:");
		}
	}

	// Show the complete movie list with movie title, movie time and price.
	private void showMovieList() {
		for (Movie movie : this.movieList) {
			System.out.println(movie.getName() + " - " + movie.getMovieTime()
					+ " - " + movie.getPrice() + "€");
		}
	}
}