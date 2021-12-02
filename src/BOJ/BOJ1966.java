package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1966 {
	
	static int N, M;
	static int[] priorities;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int TC = Integer.parseInt(in.readLine());
		
		for(int tc = 0; tc < TC; tc++) {
			st = new StringTokenizer(in.readLine(), " ");
			
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			priorities = new int[N];
			
			st = new StringTokenizer(in.readLine(), " ");
			for(int i = 0; i < N; i++) {
				priorities[i] = Integer.parseInt(st.nextToken());
			}
			
		}
		
	}

}
