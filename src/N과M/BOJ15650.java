package N과M;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 조합
 */
public class BOJ15650 {
	
	static int N, M;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(in.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		int[] numbers = new int[M];
		combination(0, numbers, 0);
		
	}

	private static void combination(int index, int[] numbers, int starIdx) {
		if(index >= M) {
			for(int i = 0; i < M; i++) {
				System.out.print(numbers[i] + " ");
			}
			System.out.println();
			return;
		}

		/*
		 * visited가 필요 없다, 그 다음애를 방문하면 됨
		 */
		for(int i = starIdx; i < N; i++) {
			numbers[index] = i + 1;
			combination(index + 1, numbers, i + 1);
		}
	}
		

}
