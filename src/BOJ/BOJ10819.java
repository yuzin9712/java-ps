package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ10819 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int N = Integer.parseInt(in.readLine());
		
		int[] arr = new int[N];
		st = new StringTokenizer(in.readLine(), " ");
		
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		System.out.println(Arrays.toString(arr));
		
		
		int r = N / 2;
		int sum = N % 2 == 0 ? 0 : arr[r];
		System.out.println(r);
		
		for(int i = 0; i < r; i++) {
			System.out.println(arr[N - i - 1] + " " + arr[i]);
			sum += Math.abs(arr[N - i - 1] - arr[i]);
		}
		
		System.out.println(sum);
		
		
		
	}
	
	
}

/*
 * 0 0 0 20 0 0
 * 20 15 10 8 4 1
 * 
 */
