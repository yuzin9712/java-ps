package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ2428 {
	
	static int[] arr;
	static int N;
	static long result;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		N = Integer.parseInt(in.readLine());
		
		arr = new int[N];
		
		st = new StringTokenizer(in.readLine(), " ");
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		
		for(int i = 0; i < N - 1; i++) {			
			int left = i, right = N - 1;
			int diff = binarySearch(left, right);
			System.out.println("left= " + left + " diff= " + diff);
			
		}
		
		
//		System.out.println(Arrays.toString(arr));
		
		System.out.println(result);
	}
	
	//1 2 3 4 5 6 7 8 9 10
	//10 11 12

	private static int binarySearch(int left, int right) {
		
		while(left < right) {
			int mid = (left + right) / 2;
//			System.out.println("left= " + left + " right= " + right + " mid = " + mid);
			
			//비교해야할 조건에 들어가면, 범위 조
			if(arr[left] >= (double)arr[mid] * 0.9) {
				left = mid + 1;
			} 
			
			//조건에 안맞으면, 오른쪽을 mid로..?
			else {
				right = mid;
			}

		}
		
		return right;

		
	}

}
