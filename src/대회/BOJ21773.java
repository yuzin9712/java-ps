package 대회;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ21773 {
	
	static int T, n;
	static PriorityQueue<Process> pq;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(in.readLine());
		T = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		
		pq = new PriorityQueue<Process>(new Comparator<Process>() {
			@Override
			public int compare(Process o1, Process o2) {
				if(o1.c == o2.c) {
					return Integer.compare(o1.a, o2.a);
				}
				return Integer.compare(o2.c, o1.c);
			}
		});
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(in.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			pq.offer(new Process(a, b, c));
		}
		
		int time = 1;
		
		
		while(!pq.isEmpty() && time <= T) {
			Process current = pq.poll();
			
			sb.append(current.a).append("\n");
			
			
			if(current.b > 1) {
				current.b -= 1;
				current.c -= 1;
				pq.offer(current);
			}
			time++;
		}
		
		System.out.println(sb.toString());
		
		
	}
	
	static class Process {
		int a;
		int b;
		int c;
		
		public Process(int a, int b, int c) {
			super();
			this.a = a;
			this.b = b;
			this.c = c;
		}

		@Override
		public String toString() {
			return "Process [a=" + a + ", b=" + b + ", c=" + c + "]";
		}
		
		
		
	}

}
