package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BOj14621 {
	static int N, M;
	static char[] school;
	static int[] parents;
	static List<Edge> edges;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		st = new StringTokenizer(in.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		school = new char[N];
		parents = new int[N];
		edges = new ArrayList<Edge>();
		
		init();
		
		st = new StringTokenizer(in.readLine(), " ");
		for(int i = 0; i < N; i++)	school[i] = st.nextToken().charAt(0);
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			int from = Integer.parseInt(st.nextToken()) - 1;
			int to = Integer.parseInt(st.nextToken()) - 1;
			int cost = Integer.parseInt(st.nextToken());
			
			if(school[from] == school[to])	continue;
			
			edges.add(new Edge(from, to, cost));
			
		}
		
		Collections.sort(edges);
		
		int answer = 0;
		int cnt = 0;
		
		for(Edge e : edges) {
			
			if(union(e.from, e.to)) {
				answer += e.cost;
				cnt++;
			}
		}
		
		if(cnt < N - 1)	answer = -1;
		
		System.out.println(answer);
	}
	
	private static void init() {
		for(int i = 0; i < N; i++)	parents[i] = i;
		
	}

	private static boolean union(int a, int b) {
		int pa = find(a);
		int pb = find(b);
		
		if(pa == pb)	return false;
		
		parents[pb] = find(pa);
		return true;
	}

	private static int find(int a) {
		if(a == parents[a])	return a;
		return parents[a] = find(parents[a]);
	}

	static class Edge implements Comparable<Edge>{
		int from;
		int to;
		int cost;
		
		public Edge(int from, int to, int cost) {
			super();
			this.from = from;
			this.to = to;
			this.cost = cost;
		}

		@Override
		public int compareTo(Edge o) {
			return this.cost - o.cost;
		}
		
		
	}

}
