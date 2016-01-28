package src;

public class Customer {

	private String customersName;
	private String customersNumber;

	public Customer(String customersName, String customersNumber) {
		
		this.customersName = customersName;
		this.customersNumber = customersNumber;
	}

	public String getCustomersName() {
		
		return customersName;
	}

	public String getCustomersNumber() {
		
		return customersNumber;
	}
}
