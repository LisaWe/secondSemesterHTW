package src;

public class Node<E> {

	public Node<E> next;
	private E data;

	public Node(E data) {
		
		this.data = data;
	}

	public Node(E data, Node next) {
		
		this.data = data;
		this.next = next;
	}

	public String toString() {
		
		return data.toString();
	}

	public E getData() {
		
		return data;
	}

	public void setData(E data) {
		
		this.data = data;
	}

	public Node<E> getNext() {
		
		return next;
	}

	public void setNext(Node next) {
		
		this.next = next;
	}

	public int toInt() {
		
		char dataChar = (char) data;
		int dataInt = Character.getNumericValue(dataChar);
		
		return dataInt;
	}

	public char toChar() {
		
		char dataChar = (char) data;
		
		return dataChar;
	}

}
