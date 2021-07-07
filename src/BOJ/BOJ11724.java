package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ11724 {
	static int N, M;
	static int[] parents;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		st = new StringTokenizer(in.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		parents = new int[N];
		
		init();
		
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			
			int from = Integer.parseInt(st.nextToken()) - 1;
			int to = Integer.parseInt(st.nextToken()) - 1;
			
			union(from, to);
			
		}
		
		Set<Integer> set = new HashSet<Integer>();
		for(int i = 0; i < N; i++) {
			parents[i] = find(i);
			set.add(parents[i]);
		}
		
//		System.out.println(Arrays.toString(parents));
		
		System.out.println(set.size());
		
	}

	private static void union(int a, int b) {
		int pa = find(a);
		int pb = find(b);
		
		if(pa == pb)	return;
		
		parents[pb] = find(pa);
		
	}

	private static int find(int a) {
		if(a == parents[a])	return a;
		return parents[a] = find(parents[a]);
	}

	private static void init() {
		
		for(int i = 0; i < N; i++) {
			parents[i] = i;
		}
		
	}

}
