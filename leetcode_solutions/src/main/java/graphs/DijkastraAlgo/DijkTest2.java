package graphs.DijkastraAlgo;

import java.util.*;

public class DijkTest2 {
		static class Edge {
			String target;
			int weight;

			Edge(String target, int weight) {
				this.target = target;
				this.weight = weight;
			}
		}

		public static void dijkstra(Map<String, List<Edge>> graph, String start) {
			Map<String, Integer> dist = new HashMap<>();
			for (String node : graph.keySet()) {
				dist.put(node, Integer.MAX_VALUE);
			}
			dist.put(start, 0);

			PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>(Map.Entry.comparingByValue());
			pq.offer(new AbstractMap.SimpleEntry<>(start, 0));

			while (!pq.isEmpty()) {
				Map.Entry<String, Integer> current = pq.poll();
				String node = current.getKey();
				int currDist = current.getValue();

				if (currDist > dist.get(node)) continue;

				for (Edge edge : graph.getOrDefault(node, new ArrayList<>())) {
					int newDist = currDist + edge.weight;
					if (newDist < dist.getOrDefault(edge.target, Integer.MAX_VALUE)) {
						dist.put(edge.target, newDist);
						pq.offer(new AbstractMap.SimpleEntry<>(edge.target, newDist));
					}
				}
			}

			// Print result
			System.out.println("Shortest distances from node " + start + ":");
			for (Map.Entry<String, Integer> entry : dist.entrySet()) {
				System.out.println("To node " + entry.getKey() + " = " + entry.getValue());
			}
		}

		public static void main(String[] args) {
			Map<String, List<Edge>> graph = new HashMap<>();

			graph.computeIfAbsent("A", k -> new ArrayList<>()).add(new Edge("B", 4));
			graph.computeIfAbsent("A", k -> new ArrayList<>()).add(new Edge("C", 1));
			graph.computeIfAbsent("C", k -> new ArrayList<>()).add(new Edge("B", 2));
			graph.computeIfAbsent("B", k -> new ArrayList<>()).add(new Edge("D", 1));
			graph.computeIfAbsent("C", k -> new ArrayList<>()).add(new Edge("D", 5));

			dijkstra(graph, "A");
		}
	}