package Programmers;

public class WC1 {
	public long solution(int price, int money, int count) {
        long answer = -1;
        
        long need = (long)count * (long)(count + 1) / 2 * price;
        
        answer = (money >= need) ? 0 : need - money;

        return answer;
    }
}
