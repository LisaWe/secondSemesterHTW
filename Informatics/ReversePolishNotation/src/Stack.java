package src;

public interface Stack<E> {
	
	
	public Node<E> pop();
	public Node<E> top();
	public boolean isEmpty();
	public String toString();
	
	public void push(E data);
}
