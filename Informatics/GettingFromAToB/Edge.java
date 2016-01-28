public class Edge {
	
	public Node start;
	private Node end;
	public int weight;

	public Edge(int weight, Node start, Node end) {
		
		this.weight = weight;
		this.start = start;
		this.end = end;
	}

	public int getWeight() {
		
		return weight;
	}

	public void setWeight(int weight) {
		
		this.weight = weight;
	}

	public void setStart(Node start) {
		
		this.start = start;
	}

	/*
	 * Gibt Anfangsknoten zurück
	 */
	public Node getStart() {
		return start;
	}

	public void setEnd(Node end) {
		
		this.end = end;
	}

	public Node getEnd() {

		return end;

	}

	// Print out information about edge
	public String toString() {
		return "from " + start + " to " + end + " it takes " + weight
				+ " hour(s).";
	}
}
