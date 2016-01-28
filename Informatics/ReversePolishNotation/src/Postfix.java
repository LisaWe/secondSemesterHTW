package src;

public class Postfix {
	
	LinkedListStack<Object> stack = new LinkedListStack<Object>();

	public void convertInfixToPostfixValue(String infix) throws Exception {
		
		String postfix = infixToPostfix(infix);
		int evaluatedPostfix = evaluate(postfix);
		
		System.out.println("The result is: " + evaluatedPostfix);
	}

	public String infixToPostfix(String ifx) throws Underflow {
		
		String postfixString = "";
		
		for (int i = 0; i < ifx.length(); ++i) {
			char singleChar = ifx.charAt(i);
		
			if (singleChar == '(') {
				stack.push('(');
			} else if (singleChar == ')') {
				Character charOnStack = stack.top().toChar();
				
				while (!(charOnStack.equals('(')) && !(stack.isEmpty())) {
					postfixString += charOnStack.charValue();
					stack.pop();
					charOnStack = stack.top().toChar();
				}
				stack.pop();
			} else if (singleChar == '+' || singleChar == '-') {
				if (stack.isEmpty()) {
					stack.push(singleChar);
				} else {
					Character charOnStack = stack.top().toChar();
					while (!(stack.isEmpty()
							|| charOnStack.equals(new Character('(')) || charOnStack
								.equals(new Character(')')))) {
						stack.pop();
						postfixString += charOnStack.charValue();
					}
					stack.push(singleChar);
				}

			} else if (singleChar == '*' || singleChar == '/') {
				if (stack.isEmpty()) {
					stack.push(singleChar);
				} else {
					Character charOnStack = stack.top().toChar();
					while (!charOnStack.equals(new Character('+'))
							&& !charOnStack.equals(new Character('-'))
							&& !stack.isEmpty()) {
						stack.pop();
						postfixString += charOnStack.charValue();
					}
					stack.push(singleChar);
				}
			} else if (singleChar == '^') {
				if (stack.isEmpty()) {
					stack.push(singleChar);
				} else {
					Character charOnStack = stack.top().toChar();
					while (!charOnStack.equals(new Character('+'))
							&& !charOnStack.equals(new Character('-'))
							&& !charOnStack.equals(new Character('*'))
							&& !charOnStack.equals(new Character('/'))
							&& !stack.isEmpty()) {
						stack.pop();
						postfixString += charOnStack.charValue();
					}
					stack.push(singleChar);
				}
			} else {
				postfixString += singleChar;
			}
		}
		while (!stack.isEmpty()) {
			Character charOnStack = stack.top().toChar();
			if (!charOnStack.equals(new Character('('))) {
				stack.pop();
				postfixString += charOnStack.charValue();
			}
		}
		return postfixString;
	}

	public int evaluate(String pfx) throws Exception {
		
		int right = 0;
		int left = 0;
		int result = 0;
		char[] postfixCharArray = pfx.toCharArray();

		for (char singleChar : postfixCharArray) {
			if (Character.isDigit(singleChar)) {
				stack.push(singleChar);
			} else {
				right = Integer.parseInt(stack.pop().toString());
				left = Integer.parseInt(stack.pop().toString());
				if (singleChar == '*') {
					result = left * right;
				} else if (singleChar == '/') {
					result = left / right;
				} else if (singleChar == '+') {
					result = left + right;
				} else if (singleChar == '-') {
					result = left - right;
				} else if (singleChar == '^') {
					result = (int) Math.pow(left, right);
				}
				stack.push(result);
			}
		}
		return result;
	}
}
