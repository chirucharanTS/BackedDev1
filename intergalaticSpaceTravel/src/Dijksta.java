import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class Dijksta {
	public int shortestTime(Map<Integer,List<Neighbour>> graph, Map<Integer,Set<Integer>> timeStamp,int src,int dst,int n) {
		
		if(graph.isEmpty()) return -1;
		
		int [] cost = new int[n+1];
		Arrays.fill(cost, Integer.MAX_VALUE);
		PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> {
			return a[1]-b[1];
		});
		cost[src] = 0;
		boolean [] visited = new boolean[n+1];
		pq.add(new int[]{src,0});
		while(!pq.isEmpty()) {
			int [] inp = pq.poll();
			int node = inp[0];
			int wt = inp[1];
			if(visited[node]) continue;
			//System.out.println(graph.get(node).size());
			for(int i = 0;i < graph.get(node).size();i++) {
				Neighbour neigh = graph.get(node).get(i);
				if(visited[neigh.node]) continue;
				int time = neigh.cost + wt;
				if(timeStamp.containsKey(neigh.node)) {
					Set<Integer> delays = timeStamp.get(neigh.node);
					while(delays.contains(time)) {
						++time;
					}
				}
				if(cost[neigh.node] > time) {
					cost[neigh.node] = time;
					pq.add(new int[] {neigh.node, time});
				} 
			}
			visited[node] = true;
		}
		
		return cost[dst]==Integer.MAX_VALUE?-1:cost[dst];
	}
}
