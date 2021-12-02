package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1956 {
	
	static int V, E;
	static int[][] graph;
	static final int INF = 1000000000;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		st = new StringTokenizer(in.readLine(), " ");
		
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		graph = new int[V][V];
		
		init();
		
		for(int i = 0; i < E; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			int from = Integer.parseInt(st.nextToken()) - 1;
			int to = Integer.parseInt(st.nextToken()) - 1;
			int cost = Integer.parseInt(st.nextToken());
			
			graph[from][to] = cost;
		}
				 
		for(int k = 0; k < V; k++) {
			for(int i = 0; i < V; i++) {
				for(int j = 0; j < V; j++) {
					if(graph[i][j] > graph[i][k] + graph[k][j]) {
						graph[i][j] = graph[i][k] + graph[k][j];
					}
				}
			}
		}
		
		int result = INF;
		for(int i = 0; i < V; i++) {
			if(result > graph[i][i]) {
				result = graph[i][i];
			}
		}
		
		if(result == INF) {
			System.out.println(-1);
		} else {
			System.out.println(result);	
		}
		
	}

	private static void init() {
		for(int i = 0; i < V; i++) {
			Arrays.fill(graph[i], INF);
		}
		
	}

}
