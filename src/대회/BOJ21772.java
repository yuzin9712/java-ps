package 대회;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ21772 {
	
	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {1, -1, 0, 0};
	
	static int R, C, T;
	static int MAX;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(in.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		
		char[][] map = new char[R][C];
		
		int sx = 0, sy = 0;
		
		for(int i = 0; i < R; i++) {
			String line = in.readLine();
			for(int j = 0; j < C; j++) {
				map[i][j] = line.charAt(j);
				if(map[i][j] == 'G') {
					sx = i;	sy = j;
				}
			}
		}
		
		dfs(map, sx, sy, 0, 0);
		
		System.out.println(MAX);
	}

	private static void dfs(char[][] map, int sx, int sy, int cnt, int time) {
		if(time > T)	return;
		if(cnt > MAX)	MAX = cnt;
		
		
		for(int i = 0; i < 4; i++) {
			int nx = sx + dx[i];
			int ny = sy + dy[i];
			
			if(nx < 0 || nx >= R || ny < 0 || ny >= C || map[nx][ny] == '#')	continue;
			
			char current = map[nx][ny];
			map[nx][ny] = '.';
			
			if(current == 'S')	dfs(map, nx, ny, cnt + 1, time + 1);
			else						dfs(map, nx, ny, cnt, time + 1);
			
			map[nx][ny] = current;
		}
		
		
		
	}

	private static char[][] copy(char[][] map) {
		char[][] newMap = new char[R][C];
		
		for(int i = 0; i < R; i++) {
			newMap[i] = map[i].clone();
		}
		return newMap;
	}



}
