package src;

import java.util.Scanner;

public class Main {

	private static Scanner scanInfix;

	public static void main(String[] args) throws Exception {
		
		Postfix post = new Postfix();
		scanInfix = new Scanner(System.in);
		
		System.out.print("Please enter an infix:\n");
		String infix = scanInfix.nextLine();
		post.convertInfixToPostfixValue(infix);
		// post.evaluate(infix);
		// post.infixToPostfix("(3+4)*5");
	}
}
