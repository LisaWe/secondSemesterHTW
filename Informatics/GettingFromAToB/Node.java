import java.util.ArrayList;
import java.util.Iterator;

public class Node implements Comparable<Node> {

	private String name;
	private ArrayList<Node> adjacencyList;
	public ArrayList<Edge> adjacencyEdges;
	public boolean visited;
	public double minDistance = Double.POSITIVE_INFINITY;
	public Node previous;

	public int compareTo(Node other) {
		
		return Double.compare(minDistance, other.minDistance);
	}

	public Node(String name, boolean visited) {
		
		visited = false;
		this.name = name;
		this.adjacencyList = new ArrayList<Node>();
		this.adjacencyEdges = new ArrayList<Edge>();

	}

	public String getName() {
		
		return name;
	}

	public void setName(String name) {
		
		this.name = name;
	}

	public ArrayList<Edge> getEdges() {
		
		return adjacencyEdges;
	}

	public void setEdges(ArrayList<Edge> adjacencyEdges) {
		
		this.adjacencyEdges = adjacencyEdges;
	}

	public void addEdge(Edge e) {
		
		adjacencyEdges.add(e);
	}

	public void deleteEdge(Edge e) {
		
		Iterator<Edge> it = adjacencyEdges.iterator();
		
		while (it.hasNext()) {
			Edge edge = it.next();
			
			if (edge == e)
				it.remove();
		}
	}
	
	public String toString() {
		
		String e = "0";
		
		if (adjacencyEdges.size() != 0)
			e = "" + adjacencyEdges.size();
		
		return this.name + "(has " + e + " egde(s))";
	}

	public boolean edgeAlreadyExists(Edge e) {
		
		for (Edge edge : adjacencyEdges) {
			if ((edge.getEnd().getName().equals(e.getEnd().getName()))
					&& (edge.getStart().getName()
							.equals(e.getStart().getName()))) {
				return true;
			}
		}
		return false;
	}
}