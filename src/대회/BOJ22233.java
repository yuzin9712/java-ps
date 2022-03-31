package 대회;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ22233 {

	static int N, M;
	static Map<String, Integer>	map;
	static int[][] temp;
	static Set<Integer> set;
	
	public static void main(String[] args) throws IOException {
		
//		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = null;
//		StringBuilder sb = new StringBuilder();
//		
//		st = new StringTokenizer(in.readLine());
//		N = Integer.parseInt(st.nextToken());
//		M = Integer.parseInt(st.nextToken());
//		
//		map = new HashMap<String, Integer>();
		set = new HashSet<Integer>();
		
		int a = 1;
		set.add(a);
		System.out.println(set.size());
		
		for (int e : set) {

		    System.out.print(e + " ");

		}
		
//		for(int i = 0; i < N; i++) {
//			map.put(in.readLine(), 0);
//		}
//		
//		for(int i = 0; i < M; i++) {
//			st = new StringTokenizer(in.readLine(), ",");
//			
//			while(st.hasMoreTokens()) {
//				String current = st.nextToken();
//				
//				if(map.containsKey(current))	map.remove(current);
//			}
//			
//			sb.append(map.size()).append("\n");
//		}
//		
//		for(int[] is: temp) {
//			System.out.println(Arrays.toString(is));
//		}
//		
//		System.out.println(sb.toString());
	}
}
