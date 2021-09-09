package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ1138 {
	
	static int N;
	static int[] arr;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(in.readLine());
		arr = new int[N + 1];
		
		st = new StringTokenizer(in.readLine(), " ");
		for(int i = 1; i <= N; i++) {
			int number = Integer.parseInt(st.nextToken());
			
			int cnt = 0;
			int j = 1;
			
			for(; j <= N; j++) {
				if(arr[j] == 0)	cnt++;
				if(cnt == number + 1)	break;
				
			}
	
			arr[j] = i;
			    
		}
		
		for(int i = 1; i <= N; i++) {
			sb.append(arr[i]).append(" ");
		}
		
		System.out.println(sb.toString());

		
	}
}
