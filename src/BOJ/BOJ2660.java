package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ2660 {
	
	static int[][] map;
	static int N;
	static int[] score;
	static int MIN = Integer.MAX_VALUE;

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(in.readLine());
		
		map = new int[N][N];
		score = new int[N];
		
		
		while(true) {
			st = new StringTokenizer(in.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			
			if(from == -1 && to == -1)	break;
			
			map[from - 1][to - 1] = 1;
			map[to - 1][from - 1] = 1;
		}
		
		
		for(int i = 0; i < N; i++) {
			bfs(i);
		}
		
//		System.out.println(Arrays.toString(score));
		
		sb.append(MIN).append(" ");
		int cnt = 0;
		
		for(int i = 0; i < N; i++) {
			if(score[i] == MIN) {
				cnt++;
			}
		}
		
		sb.append(cnt).append("\n");
		
		for(int i = 0; i < N; i++) {
			if(score[i] == MIN)	sb.append(i + 1).append(" ");
		}
		
		System.out.println(sb.toString());
	}

	private static void bfs(int vertex) {
		int cnt = 0;
		int answer = 0;
		Queue<int[]> q = new LinkedList<int[]>();
		boolean[] visited = new boolean[N];
		
		int start = vertex;
		q.offer(new int[] {start, 0});
		visited[start] = true;
		cnt++;
		
		while(!q.isEmpty()) {
			int[] current = q.poll();
			start = current[0];
			int step = current[1];
			
			if(cnt == N) {
				answer = step;
			}
			
			for(int i = 0; i < N; i++) {
				if(visited[i])	continue;
				if(map[start][i] != 1)	continue;
				
				q.offer(new int[] {i, step + 1});
				visited[i] = true;
				cnt++;
			}
		}
		
		score[vertex] = answer;
		if(MIN > answer)	MIN = answer;
	
	}

}
