import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class FindingThePath {

	private Node A, B, C, D, E, F, startNode, goal;
	private ArrayList<Edge> connections;
	private ArrayList<Node> allNodes;
	private Queue<Node> visitedNodes;
	private Queue<Node> loesung;
	private boolean goalFound;

	public FindingThePath() {

		allNodes = new ArrayList<>();
		visitedNodes = new LinkedList<Node>();
		loesung = new LinkedList<Node>();

		createNodes();

		// startNode = A;
		// goal = E;
		// goalFound = false;
		//
		// connections = new ArrayList<>();

		createEdges();
	}

	public void createNodes() {

		A = new Node("City A ", false);
		B = new Node("City B ", false);
		C = new Node("City C ", false);
		D = new Node("City D ", false);
		E = new Node("City E ", false);
		F = new Node("City F ", false);

	}

	public void createEdges() {

		A.addEdge(new Edge(20, A, B));
		A.addEdge(new Edge(40, A, C));
		// A.addEdge(new Edge(20, A, E));
		B.addEdge(new Edge(14, B, C));
		B.addEdge(new Edge(14, B, F));
		C.addEdge(new Edge(19, C, D));
		// C.addEdge(new Edge(19, C, D));
		D.addEdge(new Edge(3, D, E));
		E.addEdge(new Edge(9, E, A));
		F.addEdge(new Edge(9, F, D));
		C.addEdge(new Edge(9, C, E));

		allNodes.add(A);
		allNodes.add(B);
		allNodes.add(C);
		allNodes.add(D);
		allNodes.add(E);
		allNodes.add(F);
	}

	public void findShortestPath() {

		Node n = startNode;
		System.out.println("Root is " + n.getName());

		while (goalFound == false) {
			n.visited = true;
			visitedNodes.add(n);

			Node headOfQueue = visitedNodes.peek();
			loesung.add(headOfQueue);

			if (headOfQueue.equals(goal)) {
				System.out.println("Goal found!\nShortest connection from "
						+ startNode.getName() + " to " + goal.getName()
						+ " over cities: ");
				for (Node c : loesung) {
					System.out.println(c.getName());
				}
				goalFound = true;
			} else {
				connections = headOfQueue.getEdges();

				for (Edge connection : connections) {
					Node e = connection.getEnd();

					if (e.visited == false) {
						visitedNodes.add(e);
						e.visited = true;
					}else {
						loesung.remove(headOfQueue);
					}
				}
				if (connections.isEmpty()) {
					loesung.remove(headOfQueue);
				}
			}
			visitedNodes.remove(headOfQueue);

		}
	}

	// Dijkstra
	public void computePaths(Node start) {

		start.minDistance = 0.;
		PriorityQueue<Node> vertexQueue = new PriorityQueue<Node>();

		vertexQueue.add(start);

		while (!vertexQueue.isEmpty()) {
			Node u = vertexQueue.poll();
			
			for (Edge e : u.adjacencyEdges) {
				Node v = e.start;
				double weight = e.getWeight();
				double distanceTroughU = u.minDistance + weight;

				if (distanceTroughU < v.minDistance) {
					vertexQueue.remove(v);
					v.minDistance = distanceTroughU;
					v.previous = u;
					vertexQueue.add(v);
				}
			}
		}
	}

	public List<Node> getCheapestPathTo(Node start) {

		List<Node> path = new ArrayList<Node>();
		
		for (Node node = start; node != null; node = node.previous)
			path.add(node);
		
		return path;
	}

	public void getCheapestPath() {

		computePaths(A);
		
		for (Node n : allNodes) {
			System.out.println("Distance to " + n + ": " + n.minDistance);
			List<Node> path = getCheapestPathTo(n);
			System.out.println("Cheapeast Path: " + path);
		}
	}
}