package src;

public class LinkedListStack<E> implements Stack<E> {
	
	private Node<E> first;

	public void push(E data) {
		
		if (first == null) {
			first = new Node<E>(data);
		} else {
			Node<E> node = new Node<E>(data);
			node.setNext(first);
			first = node;
		}
	}

	public Node<E> pop() {
		
		Node<E> node = null;
		
		if (first == null) {
			System.out.println("stack empty");
		} else {
			node = first;
			first = first.getNext();
		}
		return node;
	}

	public Node<E> top() {
		
		if (first == null) 
			return null;
		else 
			return first;
	}

	public boolean isEmpty() {
		
		if (first == null) 
			return true;
		else 
			return false;
	}

	public String toString() {
		
		Node<E> currentNode = first;
		String outputText = "Your stack: ";
		
		while (currentNode != null) {
			outputText += "\n" + currentNode.getData();
			currentNode = currentNode.next;
		}
		return outputText;
	}
}
