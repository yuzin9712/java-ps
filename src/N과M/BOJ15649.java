package N과M;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 순열
 */

public class BOJ15649 {

	static int N, M;
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		st = new StringTokenizer(in.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
	
		boolean[] isVisited = new boolean[N];
		int[] numbers = new int[M];
		
		permutation(0, numbers, isVisited);
		
	}


	private static void permutation(int index, int[] numbers, boolean[] isVisited) {
		if(index >= M) {
			for(int i = 0; i < M; i++) {
				System.out.print(numbers[i] + " ");
			}
			System.out.println();
			return;
		}
		
		for(int i = 0; i < N; i++) {
			if(isVisited[i])	continue;
			isVisited[i] = true;
			numbers[index] = i + 1;
			permutation(index + 1, numbers, isVisited);
			isVisited[i] = false;
		}
		
	}

}
