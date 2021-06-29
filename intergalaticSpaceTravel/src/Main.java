import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;


public class Main {
	public static void main(String[] args) {
		FastReader fr = new FastReader();
		Main mainClass = new Main();
		int n = fr.nextInt();
		int m = fr.nextInt();
		
		int [][] input = new int[m][3];
		for(int i = 0;i < m;i++) {
			input[i][0] = fr.nextInt();
			input[i][1] = fr.nextInt();
			input[i][2] = fr.nextInt();
		}
		Map<Integer,Set<Integer>> inputTimeStamp = new HashMap<>();
		
		for(int i = 0;i < n;i++) {
			int numberOfTimeStamps = fr.nextInt();
			if(numberOfTimeStamps == 0) continue;
			
			Set<Integer> timeStamp = new HashSet<Integer>();
			for(int j = 0;j < numberOfTimeStamps;j++) {
				timeStamp.add(fr.nextInt());
			}
			inputTimeStamp.put(i+1, timeStamp);
		}
		
		Map<Integer,List<Neighbour>> graph = Graph.buildGraph(input);
		//System.out.println(graph);
		
		Dijksta dijksta = new Dijksta();
		System.out.println(dijksta.shortestTime(graph, inputTimeStamp,1,n,n));
		
		
	}
	
	
	
	static class FastReader 
    { 
        BufferedReader br; 
        StringTokenizer st; 
  
        public FastReader() 
        { 
            br = new BufferedReader(new
                     InputStreamReader(System.in)); 
        } 
  
        String next() 
        { 
            while (st == null || !st.hasMoreElements()) 
            { 
                try
                { 
                    st = new StringTokenizer(br.readLine()); 
                } 
                catch (IOException  e) 
                { 
                    e.printStackTrace(); 
                } 
            } 
            return st.nextToken(); 
        } 
  
        int nextInt() 
        { 
            return Integer.parseInt(next()); 
        } 
  
        long nextLong() 
        { 
            return Long.parseLong(next()); 
        } 
  
        double nextDouble() 
        { 
            return Double.parseDouble(next()); 
        } 
  
        String nextLine() 
        { 
            String str = ""; 
            try
            { 
                str = br.readLine(); 
            } 
            catch (IOException e) 
            { 
                e.printStackTrace(); 
            } 
            return str; 
        } 
    } 
}
