public class Main {

	private static RandomWeightedGraph randomGraph;
	private static FindingThePath secondTry;
	private static WeightedGraph weightedGraph;

	public static void main(String[] args) {

		// For Dijkstra
		// secondTry = new FindingThePath();
		// secondTry.getCheapestPath();

		// For breadth first search
		// secondTry = new FindingThePath();
		// secondTry.findPath();

		// create WeightedGraph
		weightedGraph = new WeightedGraph();
		weightedGraph.setEdges();
		weightedGraph.addNodesToList();
		weightedGraph.printNodeList();

		// create RandomWeightedGraph
		// randomGraph = new RandomWeightedGraph(8,10,10, new Node("Start",
		// false));

	}

}
