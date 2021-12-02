package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ14940 {
	static int[] dx = {0, 1, -1, 0};
	static int[] dy = {1, 0, 0, -1};
	
	static int N, M;
	static int[][] graph;
	static int[][] result;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(in.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		graph = new int[N][M];
		result = new int[N][M];
		
		init();
		
		int x = 0, y = 0;
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			for(int j = 0; j < M; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
				if(graph[i][j] == 2) {
					x = i;	y = j;
				}
				
				if(graph[i][j] == 0)	result[i][j] = 0;
			}
		}
		
		
		bfs(x, y);
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				sb.append(result[i][j]).append(" ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb.toString());
		
	}

	private static void init() {
		for(int i = 0; i < N; i++) {
			Arrays.fill(result[i], -1);
		}
		
	}

	private static void bfs(int x, int y) {
		Queue<int[]> q = new LinkedList<int[]>();
		boolean[][] visited = new boolean[N][M];
		
		int z = 0;
		q.offer(new int[] {x, y, z});
		visited[x][y] = true;
		result[x][y] = 0;
		
		while(!q.isEmpty()) {
			int[] current = q.poll();
			x = current[0];
			y = current[1];
			z = current[2];
			
			for(int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				int nz = z + 1;
				
				if(nx < 0 || nx >= N || ny < 0 || ny >= M || visited[nx][ny])	continue;

				visited[nx][ny] = true;
				
				if(graph[nx][ny] == 0) {
					continue;
				}
				
				q.offer(new int[] {nx, ny, nz});
				result[nx][ny] = nz;
			}
		}
		
		
	}

}
