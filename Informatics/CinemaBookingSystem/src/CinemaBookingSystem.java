package src;

import java.util.ArrayList;
import java.util.Scanner;

public class CinemaBookingSystem {

	static ArrayList<Booking> bookings = new ArrayList<>();
	static ArrayList<Customer> customers = new ArrayList<>();
	static ArrayList<Theater> theaters = new ArrayList<>();
	public static ArrayList<Movie> movieList = new ArrayList<>();
	static Movie movie;
	static Customer customer;
	static Scanner scan = new Scanner(System.in);
	static String name;
	static int number;

	public static void loadMovies() {
		movieList.add(new Movie("1. Avengers", "19:00pm ", 8));
		movieList.add(new Movie("2. Pulp Fiction", "17:00pm ", 5));
		movieList.add(new Movie("3. P.s. I love You", "13:00pm ", 4));
		movieList.add(new Movie("4. Resident Evil: The Final Chapter", "21:00pm ", 9));
		movieList.add(new Movie("5. The Hunger Games: Mockingjay", "20:00pm ", 9));
		movieList.add(new Movie("6. The Babadook", "22:00pm ", 6));
	}

	// Creates a new customer or compares the entered user name with the
	// existing entries.
	// If the customer account doesn't exist yet, the new customer will be added
	// to the ArrayList customers.
	public static void createCustomer() {

		System.out.println("Please log in or sign up by entering your one-word username!");
		String customersName = scan.next();

		Customer customer = null;
		
		for (Customer c : customers) {
			if (c.getCustomersName().equals(customersName)) {
				customer = c;
				break;
			}
		}
		if (customer == null) {
			System.out.printf("An account for \"%s\" doesn't exist yet. Please add your phonenumber to create it.\n", customersName);
			
			String customersNumber = scan.next();

			customer = new Customer(customersName, customersNumber);
			customers.add(new Customer(customersName, customersNumber));
		}
		System.out.printf("\nHello %s - were happy to take your reservation.\n", customer.getCustomersName());
	}

	// Create customer, show movieplan and create the theaters.
	// Save the name of the movie and number of seats for current booking.
	// Print out a ticket for the customer.
	// The current booking can also be removed.
	public static void main(String[] args) {

		customers.add(new Customer("Lizzy", "030654321"));
		System.out.println("Welcome to Magic Cinema Berlin!\n");
		createCustomer();
		loadMovies();
		theaters.add(new Theater(1, "Theater1"));
		theaters.add(new Theater(2, "Theater2"));
		theaters.add(new Theater(3, "Theater3"));
		theaters.add(new Theater(4, "Theater4"));
		theaters.add(new Theater(5, "Theater5"));
		theaters.add(new Theater(6, "Theater6"));
		Booking booking = new Booking(movieList, theaters);
		booking.getMovie();
		booking.showBooking();
		// booking.removeReservedSeats();
	}
}
