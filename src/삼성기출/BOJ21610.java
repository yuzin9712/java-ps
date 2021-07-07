package 삼성기출;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ21610 {
	
	static int[] dx = {0, 0, -1, -1, -1, 0, 1, 1, 1};
	static int[] dy = {0, -1, -1, 0, 1, 1, 1, 0, -1};
	
	static int[] cx = {-1, -1, 1, 1};
	static int[] cy = {-1, 1, 1, -1};
	
	static int N, M;
	static int[][] map;
	static boolean[][] isCloudy;
	
	static List<Cloud> clouds;
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		st = new StringTokenizer(in.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N + 1][N + 1];
		isCloudy = new boolean[N + 1][N + 1];
		clouds = new ArrayList<Cloud>();
		
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			for(int j = 1; j <= N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		init();
		
		for(int i = 1; i <= M; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			
			int d = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken()) % N;
			
			System.out.println(clouds);
			move(d, s);
			rain();
			
			copy();
			createCloud();
			for(int[] is: map) {
				System.out.println(Arrays.toString(is));
			}
			System.out.println("====================");
			
		}
		
		
	}
	
	private static void createCloud() {
		
		clouds = new ArrayList<Cloud>();
		
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= N; j++) {
				if(isCloudy[i][j]) {
					isCloudy[i][j] = false;
					continue;
				}
				
				if(map[i][j] >= 2) {
					map[i][j] -= 2;
					isCloudy[i][j] = true;
					clouds.add(new Cloud(i, j));
				}
			}
		}
		
	}

	private static void copy() {
		
		int[][] copyMap = copyMap();
		
		for(Cloud c : clouds) {
			int x = c.x;
			int y = c.y;
			
			int cnt = 0;
			
			for(int i = 0; i < 4; i++) {
				int nx = x + cx[i];
				int ny = y + cy[i];
				
				if(isValidRange(nx, ny, copyMap))	cnt++;
			}
			
			
			map[x][y] += cnt;
			System.out.println(c + "에 비가 " + cnt + "만큼 더해져서 " + map[x][y] + "가 되었다.");
		}
		
	}

	private static int[][] copyMap() {
		int[][] copyMap = new int[N + 1][N + 1];
		
		for(int i = 0; i <= N; i++) {
			for(int j = 0; j <= N; j++) {
				copyMap[i][j] = map[i][j];
			}
		}
		return copyMap;
	}

	private static void rain() {
		for(Cloud c : clouds) {
			map[c.x][c.y]++;
		}
		
	}

	private static void move(int d, int s) {
		
		for(Cloud c : clouds) {
			int x = c.x;
			int y = c.y;
			isCloudy[x][y] = false;
			
			int nx = next(x, dx[d], s, 0);
			int ny = next(y, dy[d], s, 0);
			
			isCloudy[nx][ny] = true;
			
//			if(nx == 0)	nx = N;	if(ny == 0)	ny = N;
			
			c.x = nx;	c.y = ny;
		}
		
	}

	private static int next(int current, int d, int s, int cnt) {
		if(cnt >= s)	return current;
		
		current = current + d;
		
		if(current == 0)	current = N;
		if(current > N)		current = 1;
		
		return next(current, d, s, cnt + 1);
	}

	private static boolean isValidRange(int nx, int ny, int[][] copyMap) {
		if(nx < 1 || nx > N || ny < 1 || ny > N || copyMap[nx][ny] == 0)	return false;
		return true;
	}

	private static void init() {
		clouds.add(new Cloud(N, 1));
		isCloudy[N][1] = true;
		clouds.add(new Cloud(N, 2));		
		isCloudy[N][2] = true;
		clouds.add(new Cloud(N -1, 1));
		isCloudy[N - 1][1] = true;
		clouds.add(new Cloud(N -1, 2));
		isCloudy[N - 1][2] = true;
	}

	static class Cloud {
		int x;
		int y;
		public Cloud(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		@Override
		public String toString() {
			return "Cloud [x=" + x + ", y=" + y + "]\n";
		}
		
	}

}
