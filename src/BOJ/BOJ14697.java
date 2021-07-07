package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ14697 {
	
	static int[] arr;
	static int N;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		st = new StringTokenizer(in.readLine(), " ");
		
		arr = new int[3];
		
		arr[0] = Integer.parseInt(st.nextToken());
		arr[1]= Integer.parseInt(st.nextToken());
		arr[2] = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		Arrays.sort(arr);
		
		int max1 = N / arr[0];
		int max2 = N / arr[1];
		
		boolean flag = false;
		
		for(int i = 0; i <= max1; i++) {
			int sum = i * arr[0];
			for(int j = max2; j >= 0; j--) {
				sum += (j * arr[1]);
				
				System.out.println(sum + " => " + i + " " + j + " " + (N - sum) / arr[2]);
				if(sum <= N && (N - sum) % arr[2] == 0) {
					flag = true;
					break;
				}
			}
			if(flag)	break;
		}
		
		if(flag)	System.out.println(1);
		else		System.out.println(0);
		
	}

}
