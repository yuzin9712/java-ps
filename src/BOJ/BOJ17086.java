package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ17086 {
	
	static int N, M;
	static int[][] map;
	static int MAX;
	static int[] dx = {0, 0, 1, -1, 1, 1, -1, -1};
	static int[] dy = {1, -1, 0, 0, 1, -1, 1, -1};
	static int[][] isVisited;
	static Queue<int[]> q;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(in.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		isVisited = new int[N][M];
		
		q = new LinkedList<int[]>();
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 1)	{
					q.offer(new int[] {i, j, 0});
					isVisited[i][j]++;
				}
			}
		}
		
		bfs();
		
		System.out.println(MAX);
	}

	private static void bfs() {
		
		while(!q.isEmpty()) {
			int[] current = q.poll();
			int x = current[0];
			int y = current[1];
			int s = current[2];
			
			for(int i = 0; i < 8; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				int ns = s + 1;
				
				if(nx < 0 || nx >= N || ny < 0 || ny >= M || isVisited[nx][ny] != 0) continue;
				
				q.offer(new int[] {nx, ny, ns});
				isVisited[nx][ny] = ns;
				if(MAX < ns)	MAX = ns;
			}
		}
		
		
	}



}
