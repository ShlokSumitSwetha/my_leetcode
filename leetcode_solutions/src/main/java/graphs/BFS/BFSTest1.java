package graphs.BFS;

import java.util.*;


public class BFSTest1 {



	// Graph representation using adjacency list
	private Map<Integer, List<Integer>> adjList;

	// Constructor
	public BFSTest1() {
		adjList = new HashMap<>();
	}

	public static void main(String[] args) {
		BFSTest1 graph = new BFSTest1();

		// Adding edges
		graph.addEdge(0, 1);
		graph.addEdge(0, 2);
		graph.addEdge(1, 3);
		graph.addEdge(1, 4);
		graph.addEdge(2, 5);
		graph.addEdge(2, 6);

        /*
           Graph Structure:
               0
             /   \
           1      2
         /  \    /  \
        3    4  5    6
        */

		// Perform graphs.BFS from node 0
		graph.bfs(0);
	}

	// Method to add edges to the graph
	public void addEdge(int src, int dest) {
		adjList.putIfAbsent(src, new ArrayList<>());
		adjList.putIfAbsent(dest, new ArrayList<>());
		adjList.get(src).add(dest);
		adjList.get(dest).add(src);  // For undirected graph
	}

	// graphs.BFS traversal
	public void bfs(int startNode) {
		Queue<Integer> queue = new LinkedList<>();
		Set<Integer> visited = new HashSet<>();

		// Start from the given node
		queue.add(startNode);
		visited.add(startNode);

		System.out.println("graphs.BFS Traversal starting from node " + startNode + ":");

		while (!queue.isEmpty()) {
			int current = queue.poll();
			System.out.print(current + " ");

			// Enqueue all adjacent, unvisited nodes
			for (int neighbor : adjList.getOrDefault(current, new ArrayList<>())) {
				if (!visited.contains(neighbor)) {
					queue.add(neighbor);
					visited.add(neighbor);
				}
			}
		}
	}


}
