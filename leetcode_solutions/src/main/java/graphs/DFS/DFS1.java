package graphs.DFS;
import java.util.*;

public class DFS1 {
	// Depth-First Search using Stack (Iterative)
	public static void dfsIterative(String start, Map<String, List<String>> graph) {
		Stack<String> stack = new Stack<>();
		Set<String> visited = new HashSet<>();

		stack.push(start);

		while (!stack.isEmpty()) {
			String node = stack.pop(); // Remove last element (LIFO)

			if (!visited.contains(node)) {
				visited.add(node);
				System.out.print(node + " "); // Process the node

				// Push neighbors in reverse order to maintain correct order
				List<String> neighbors = graph.getOrDefault(node, new ArrayList<>());
				Collections.reverse(neighbors); // Reverse to maintain correct graphs.DFS order
				for (String neighbor : neighbors) {
					stack.push(neighbor);
				}
			}
		}
	}

	public static void main(String[] args) {
		// Graph represented as an adjacency list
		Map<String, List<String>> graph = new HashMap<>();
		graph.put("A", Arrays.asList("B", "C"));
		graph.put("B", Arrays.asList("D", "E"));
		graph.put("C", Arrays.asList("F"));
		graph.put("D", new ArrayList<>());
		graph.put("E", Arrays.asList("G"));
		graph.put("F", new ArrayList<>());
		graph.put("G", new ArrayList<>());

		System.out.println("graphs.DFS Iterative Traversal:");
		dfsIterative("A", graph);
	}
}