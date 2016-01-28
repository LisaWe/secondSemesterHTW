import java.util.ArrayList;
import java.util.Random;

public class RandomWeightedGraph extends WeightedGraph {

	private Random r;
	private ArrayList<Node> connectedNodes;

	public RandomWeightedGraph(int numberOfNodes, int numberOfEdges,
			int maximumWeight, Node enteredRoot)
			throws IllegalArgumentException {

		root = enteredRoot;
		r = new Random();
		
		System.out.println("Root city is: " + root.getName());

		if (numberOfEdges > numberOfNodes * (numberOfNodes - 1) + 1
				|| numberOfNodes > numberOfEdges) {
			System.out.println("Number of Edges must be higher or equal to number of Nodes.");
		}

		int difference = numberOfEdges - numberOfNodes;
		connectedNodes = new ArrayList<Node>();
		connectedNodes.add(root);
		Node startingNode = root;

		// Create new edges according to numberOfNodes.
		// Create new edges between root and new nodes with arbitrary weight.
		for (int i = 0; i < numberOfNodes - 1; i++) {
			
			Node n = new Node("City " + (i + 1), false);
			Edge e = new Edge(r.nextInt(maximumWeight), startingNode, n);

			System.out.println("New connection between: "
					+ startingNode.getName() + " and " + n.getName()
					+ "\nIt takes you " + e.getWeight()
					+ " hour(s) to get from " + startingNode.getName() + " to "
					+ n.getName() + ".");

			startingNode.addEdge(e);
			connectedNodes.add(n);
			startingNode = randomConnectedNode();
			System.out.println("Root is now: " + startingNode.getName());
		}

		// avoid duplication 
		for (int j = 0; j < difference; j++) {
			Node v1 = randomConnectedNode();
			Node v2 = randomConnectedNode();
			Edge e = new Edge(r.nextInt(maximumWeight), v1, v2);

			if (v1.equals(v2) || v1.edgeAlreadyExists(e)) {
				j--;
				continue;
			}

			v1.addEdge(e);
		}
	}

	private Node randomConnectedNode() {
		
		int index = r.nextInt(connectedNodes.size());
		
		return connectedNodes.get(index);
	}
}