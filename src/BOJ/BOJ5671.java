package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ5671 {
	static int N, M;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		String line = "";
		
		while((line = in.readLine()) != null) {
			
			st = new StringTokenizer(line, " ");
			
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
//			System.out.println(N + "이상 " + M + "이하에서..");
			int count = 0;
			
			for(int i = N; i <= M; i++) {
				int[] check = new int[10];
				
				int number = i;
				boolean flag = false;
				
				while(number != 0) {
					int index = number % 10;
					
					check[index]++;
					
					if(check[index] > 1) {
						flag = true;	break;
					}
					
					number /= 10;
				}
				
				if(!flag) {
					count++;
//					System.out.println(i + "is ok");
				}
				
			}
			
			System.out.println(count);
			
		}
	}
}
