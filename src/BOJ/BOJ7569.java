package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ7569 {
	
	static int M, N, H;
	static int[][][] map;
	static int nonRipen;
	static Queue<int[]> ripen;
	static int[][][] isVisited;
	static int time;
	
	static int[] dx = {1, 0, 0, -1, 0, 0};
	static int[] dy = {0, 1, -1, 0, 0, 0};
	static int[] dz = {0, 0, 0, 0, 1, -1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		st = new StringTokenizer(in.readLine()," ");
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		map = new int[H][N][M];
		isVisited = new int[H][N][M];
		ripen = new LinkedList<int[]>();
		
		for(int k = 0; k < H; k++) {
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(in.readLine()," ");
				for(int j = 0; j < M; j++) {
					map[k][i][j] = Integer.parseInt(st.nextToken());
					if(map[k][i][j] == 0)	nonRipen++;
					else if(map[k][i][j] == 1) {
						ripen.add(new int[] {k, i, j});
						isVisited[k][i][j] = 1;
					}
				}
			}
		}
		
		if(nonRipen == 0)	System.out.println(0);
		else {
			bfs();
			
			if(nonRipen == 0)	System.out.println(time - 1);
			else				System.out.println(-1);
		}
	}

	private static void bfs() {
		
		while(!ripen.isEmpty()) {
			int[] current = ripen.poll();
			int z = current[0];
			int x = current[1];
			int y = current[2];
			int t = isVisited[z][x][y];
			
			for(int i = 0; i < 6; i++) {
				int nz = z + dz[i];
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				if(nx < 0 || nx >= N || ny < 0 || ny >= M || nz < 0 || nz >= H || isVisited[nz][nx][ny] != 0 || map[nz][nx][ny] != 0)	 continue;
				
				isVisited[nz][nx][ny] = t + 1;
				time = t + 1;
				ripen.add(new int[] {nz, nx, ny});
				nonRipen--;
				
			}
			
		}
		
	}

}
