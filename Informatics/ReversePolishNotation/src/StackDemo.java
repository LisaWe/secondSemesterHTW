package src;

public class StackDemo {

	public static void main(String[] args) throws Underflow {

		LinkedListStack<Object> testStack = new LinkedListStack<Object>();

		testStack.push("Hallo");
		testStack.push(12);
		testStack.push(5);
		testStack.push("Tschüss");

		System.out.println("Step 1: \n" + testStack.toString());
		System.out.println("");
		System.out.println("Step 2: \n" + "Deleting first Object: "
				+ testStack.pop());
		System.out.println("");
		System.out.println("Step 3: \n" + "Top is :"
				+ testStack.top().getData());
		System.out.println("");
		System.out.println("Step 5: \n" + testStack.toString());
		System.out.println("");
		System.out.println("Step 6: \n" + "Is Stack empty? = "
				+ testStack.isEmpty());
		System.out.println("");
		System.out.println("Step 7: \n" + "Deleting first Object: "
				+ testStack.pop());
		System.out.println("Deleting first Object: " + testStack.pop());
		System.out.println("Deleting first Object: " + testStack.pop());
		System.out.println("");
		System.out.println("Step 8: \n" + testStack.toString());
		System.out.println("");
		System.out.println("Step 9: \n" + "Is Stack empty? = "
				+ testStack.isEmpty());
		System.out.println("");
	}

}
