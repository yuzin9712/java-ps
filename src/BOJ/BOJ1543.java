package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1543 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String document = in.readLine();
		
		String word = in.readLine();
		int wordSize = word.length();
		
		int answer = 0;
		
		String target = "";
		for(int i = 0; i < wordSize; i++) {
			target += "#";
		}

		
		while(document.indexOf(word) != -1) {
			
			int index = document.indexOf(word);
			
			document = document.substring(0, index) + target + document.substring(index + wordSize);
			
			answer++;
			
//			System.out.println(document);
			
			
		}
		
		System.out.println(answer);
	
	}

}
