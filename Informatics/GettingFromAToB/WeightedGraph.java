import java.util.ArrayList;

public class WeightedGraph {

	private Node A, B, C, D, E;
	public Node root;
	public static ArrayList<Node> nodeList;

	public WeightedGraph() {

		nodeList = new ArrayList<Node>();

		A = new Node("City 1 ", false);
		B = new Node("City 2 ", false);
		C = new Node("City 3 ", false);
		D = new Node("City 4 ", false);
		E = new Node("City 5 ", false);

		root = A;
		System.out.println(root);
	}

	public Node getRoot() {
		
		return root;
	}

	public void setEdges() {
		
		A.addEdge(new Edge(20, A, B));
		B.addEdge(new Edge(14, B, C));
		C.addEdge(new Edge(19, C, D));
		D.addEdge(new Edge(3, D, E));
		E.addEdge(new Edge(9, E, A));
	}

	public void addNodesToList() {
		
		WeightedGraph.nodeList.add(A);
		WeightedGraph.nodeList.add(B);
		WeightedGraph.nodeList.add(C);
		WeightedGraph.nodeList.add(D);
		WeightedGraph.nodeList.add(E);
	}

	public void printNodeList() {
		
		for (Node node : WeightedGraph.nodeList) {
			System.out.println(node.getEdges());
		}
	}
}