import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph {
	public static Map<Integer, List<Neighbour>> buildGraph(int [][] input) {
		Map<Integer, List<Neighbour>> graph = new HashMap<>();
		
		for(int i = 0;i < input.length;i++) {
			int node = input[i][0];
			int neigh = input[i][1];
			int cost = input[i][2];
			
			graph.putIfAbsent(node, new ArrayList<>());
			graph.putIfAbsent(neigh, new ArrayList<>());
		
			graph.get(node).add(new Neighbour(neigh,cost));
			graph.get(neigh).add(new Neighbour(node,cost));
		}
		
		return graph;
		
	}
}
