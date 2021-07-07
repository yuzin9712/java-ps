package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1967 {
	
	static int N;
	static int[][] graph;
	static int[] parents;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		N = Integer.parseInt(in.readLine());
		
		graph = new int[N][N];
		parents = new int[N];
		
		init();
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			
			int from = Integer.parseInt(st.nextToken()) - 1;
			int to = Integer.parseInt(st.nextToken()) - 1;
			int cost = Integer.parseInt(st.nextToken());
			
			graph[from][to] = cost;
			graph[to][from] = cost;
			
			parents[to] = from;
			
		}
		
		for(int i = 0; i < N; i++) {
			dfs(i, 0);
		}
	}

	private static void init() {
		Arrays.fill(parents, -1);
	}

	private static void dfs(int from, int sum) {
		
		
		
	}

}
