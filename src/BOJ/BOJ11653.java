package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ11653 {
	
	static boolean[] arr;
	static int N, NN;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(in.readLine());
		NN = N;
		
		arr = new boolean[10000001];
		
	for(int i = 2; i < Math.sqrt((double) N); i++) {
		if(arr[i])	continue;
		if(NN % i == 0)	{
			if(NN / i == 1)	arr[i] = true;
			System.out.println(i);

			NN = NN / i;
		}
	}
		
		
	}

}
