package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ11559 {
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};
	
	static char[][] graph;
	static int result;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		graph = new char[12][6];
		
		for(int i = 0; i < 12; i++) {
			graph[i] = in.readLine().toCharArray();
		}
		
		while(true) {
			int cnt = 0;
			for(int i = 0; i < 12; i++) {
				for(int j = 0; j < 6; j++) {
					if(graph[i][j] == '.')	continue;
					
					if(bfs(i, j, graph[i][j]))	cnt++;
					
				}
			}
			if(cnt == 0)	break;
			else {
				result++;
				down();
			}
		}

		
		System.out.println(result);
		
	}

	private static void down() {
		for(int j = 0; j < 6; j++) {
			Queue<Character> q = new LinkedList<Character>();
			
			for(int i = 0; i < 12; i++) {
				if(graph[12 - i - 1][j] != '.') {
					q.offer(graph[12 - i - 1][j]);
					graph[12 - i - 1][j] = '.';
				}
			}
			int size = q.size();
			for(int i = 0; i < size; i++) {
				graph[12 - i - 1][j] = q.poll();
			}
		}
		
	}

	private static boolean bfs(int x, int y, char target) {
		int cnt = 0;
		Queue<int[]> q = new LinkedList<int[]>();
		boolean[][] visited = new boolean[12][6];
		
		List<int[]> position = new ArrayList<int[]>();
		
		q.add(new int[] {x, y});
		visited[x][y] = true;
		position.add(new int[] {x, y});
		cnt++;
		
		while(!q.isEmpty()) {
			int[] current = q.poll();
			x = current[0];
			y = current[1];
			
			for(int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				if(nx >= 0 && nx < 12 && ny >= 0 && ny < 6 && !visited[nx][ny] && target == graph[nx][ny]) {
					q.add(new int[] {nx, ny});
					visited[nx][ny] = true;
					position.add(new int[] {nx, ny});
					cnt++;
				}
			}
		}
		
		if(cnt >= 4) {
			int size = position.size();
			for(int i = 0; i < size; i++) {
				int px = position.get(i)[0];
				int py = position.get(i)[1];
				
				graph[px][py] = '.';
			}
			return true;
		}
		
		return false;
		
		
	}

}
