package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ16960 {
	
	static int M, N;
	static int[][] adjMat;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(in.readLine());
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		adjMat = new int[M][N];
		
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine());
			
			int cnt = Integer.parseInt(st.nextToken());
			
			for(int j = 0; j < cnt; j++) {
				int to = Integer.parseInt(st.nextToken()) - 1;
				
				adjMat[i][to] = 1;
			}
		}

		/*
		 * N -1 개를 뽑았을때 전부 켤 수 있는지 확인해야한다?
		 */

		
		
	}

	private static void combination(int index, int k) {
		
		if(index > k) {
			return;
		}
		
//		for(int i = 0; i < )
		
	}

}
