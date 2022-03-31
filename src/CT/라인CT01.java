package CT;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class 라인CT01 {
	
	static int[] abilities = {2, 8, 3, 6, 1, 9, 1, 9}; //21
	//static int[] abilities = {7, 6, 8, 9, 10}; //22
	static int k = 2;
	static int MAX = 0;
	

	public static void main(String[] args) {
		
		Arrays.sort(abilities);
		System.out.println(Arrays.toString(abilities));
		
		int size = abilities.length;
		
		dfs(size, size - 1, k, 0);
		
		System.out.println(MAX);
		
	}


	private static void dfs(int total, int index, int curk, int sum) {

		if(total % 2 == 0 && index < 0) {
			if(sum > MAX)	MAX = sum;
			return;
		}
		
		if( total % 2 != 0 && index == 0) {
			if(curk > 0 && sum + abilities[0] > MAX)	MAX = sum + abilities[0];
			if(curk <= 0 && sum > MAX)	MAX = sum;
		}
		
		if(index >= 1) {			
			if(curk > 0) {
				dfs(total, index - 2, curk - 1, sum + abilities[index]);
				dfs(total, index - 2, curk, sum + abilities[index - 1]);
			} else {
				dfs(total, index - 2, curk, sum + abilities[index - 1]);
			}
		}
		
	}






}
