package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ2458 {
	static int N, M;
	static int[][] graph;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		st = new StringTokenizer(in.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		graph = new int[N][N];
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			int a = Integer.parseInt(st.nextToken()) - 1;
			int b = Integer.parseInt(st.nextToken()) - 1;

			graph[a][b] = -1;
			graph[b][a] = 1;
		}
		
		for(int k = 0; k < N; k++) {
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					if(graph[i][k] == -1 && graph[k][j] == -1)	graph[i][j] = -1;
					if(graph[i][k] == 1 && graph[k][j] == 1)	graph[i][j] = 1;
				}
			}
		}
		
//		for(int[] is : graph) {
//			System.out.println(Arrays.toString(is));
//		}
		

		int answer = 0;
		
		for(int i = 0; i < N; i++) {
			boolean flag = false;
			for(int j = 0; j < N; j++) {
				if(i == j)	continue;
				if(graph[i][j] == 0) {
					flag = true;
					break;
				}
			}
			
			if(!flag)	answer++;
		}
	
		System.out.println(answer);
		
	}

}
