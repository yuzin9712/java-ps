package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ18352 {
	
	static int N, M, K, X;
	static int[] d;
	static int[][] adjMat;
	static final int INF = 1000000000;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(in.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken()) - 1;
		
		adjMat = new int[N][N];
		init();
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			int from = Integer.parseInt(st.nextToken()) - 1;
			int to = Integer.parseInt(st.nextToken()) - 1;
			
			adjMat[from][to] = 1;
		}
		
		dijkstra();
		
		
		
		
	}

	private static void init() {
		for(int i = 0; i < N; i++) {
			Arrays.fill(adjMat[i], INF);
			d[i] = INF;
		}
		
	}

	// 하나에서 모든 점까지의 최단 거리
	private static void dijkstra() {
		
		//시작이 되는 점은 0이다.
		d[X] = 0;
		
		
		
	}


}
