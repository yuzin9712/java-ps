package Programmers;

public class 타겟넘버 {
	
    static int cnt;
    
    public int solution(int[] numbers, int target) {
        int answer = 0;
        
        int size = numbers.length;
        
        dfs(0, 0, size, numbers, target);
        
        answer = cnt;
        
        return answer;
    }
    
    public void dfs(int index, int sum, int size, int[] numbers, int target) {
        if(index >= size) {
            if(sum == target)   cnt++;
            return;
        }
        
        dfs(index + 1, sum + numbers[index], size, numbers, target);
        dfs(index + 1, sum - numbers[index], size, numbers, target);
    }
}
