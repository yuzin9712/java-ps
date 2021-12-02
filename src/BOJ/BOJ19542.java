package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ19542 {
	
	static int N, S, D;
	static boolean[] isVisited;
	static List[] adjList;
	static int max;
	static int result;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		st = new StringTokenizer(in.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken()) - 1;
		D = Integer.parseInt(st.nextToken());
		
		adjList = new ArrayList[N];
		isVisited = new boolean[N];
		
		init();
		
		for(int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			int from = Integer.parseInt(st.nextToken()) - 1;
			int to = Integer.parseInt(st.nextToken()) - 1;
			
			adjList[from].add(to);
			adjList[to].add(from);
			
		}
		
		dfs(S, 0);

//		max -= 1;
//		result = (max % D == 0 ? max / D : max / D + 1) * 2;
		System.out.println(max + "최대");
		
		
	}
	
	

	private static void dfs(int current, int step) {
		System.out.println((current + 1) + "에 " + step + "만큼 걸어서 방문");
		isVisited[current] = true;
		if(max < step)	max = step;
		
		List<Integer> temp = adjList[current];
		
		for(Integer e : temp) {
			if(isVisited[e])	continue;
			dfs(e, step + 1);
		}
		
	}



	private static void init() {
		for(int i = 0; i < N; i++) {
			adjList[i] = new ArrayList<Integer>();
		}
		
	}

}
