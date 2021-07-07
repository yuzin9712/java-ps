package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1967 {
	
	static int N;
	static short[][] graph;
	static int MAX = 0;
	static int MAX2 = 0;
	static int vertex1;
	static int vertex2;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		N = Integer.parseInt(in.readLine());
		
		graph = new short[N][N];
		for(int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			
			short from = (short) (Short.parseShort(st.nextToken()) - 1);
			short to = (short) (Short.parseShort(st.nextToken()) - 1);
			short cost = Short.parseShort(st.nextToken());
			
			graph[from][to] = cost;
			graph[to][from] = cost;
			
		}
		
		boolean[] visited = new boolean[N];
		dfs(0, 0, visited);
//		System.out.println(vertex1 + "까지 " + MAX + "만큼 걸린다.");
		
		MAX = 0;
		
		Arrays.fill(visited, false);
		dfs(vertex1, 0, visited);
//		System.out.println(vertex2 + "까지 " + MAX + "만큼 걸린다.");
		
		System.out.println(MAX);
	}

	private static void dfs(int vertex, int sum, boolean[] visited) {
		
//		System.out.println(vertex + "노드에 방문할 때 " + sum + "만큼 걸린 상태");
		visited[vertex] = true;
		
		if(MAX < sum) {
			MAX = sum;
			vertex1 = vertex;
		}
		
		for(int i = 0; i < N; i++) {
			if(visited[i] || graph[vertex][i] == 0)	continue;
		
			dfs(i, sum + graph[vertex][i], visited);
			
		}
		
		
		
	}

}
