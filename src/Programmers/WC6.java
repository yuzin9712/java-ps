package Programmers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WC6 {
    List<Person> list;
    public int[] solution(int[] weights, String[] head2head) {
        int[] answer;
        int size = weights.length;
        answer = new int[size];
        list = new ArrayList<Person>();
        
        for(int i = 0; i < size; i++) {
            int id = i + 1;
            int weight = weights[i];
            int total = 0, win = 0;
            int cnt = 0;
            
            for(int j = 0; j < size; j++) {
                if(head2head[i].charAt(j) != 'N')   total++;
                
                //승률구하기
                if(head2head[i].charAt(j) == 'W')   win++;
                
                //무게 많이 나가는애 이긴 경우
                if(weight < weights[j] && head2head[i].charAt(j) == 'W')    cnt++;
                
                
            }
            double winRate = 0;
            
            if(total != 0)  winRate = (double)win / total * 100;
            
            list.add(new Person(id, winRate, cnt, weight));
        }

        Collections.sort(list);
        
        for(int i = 0; i < size; i++) {
            answer[i] = list.get(i).id;
        }
        
        return answer;
    }
    
    static class Person implements Comparable<Person> {
        int id;
        double winRate;
        int cnt;
        int weight;
        
        public Person(int id, double winRate, int cnt, int weight) {
            this.id = id;
            this.winRate = winRate;
            this.cnt = cnt;
            this.weight = weight;
        }
        
        @Override
		public int compareTo(Person o) {
            if(this.winRate == o.winRate) {
                if(this.cnt == o.cnt) {
                    if(this.weight == o.weight) {
                        return this.id - o.id;
                    }
                    return o.weight - this.weight;
                }
                return o.cnt - this.cnt;
            }
			return -Double.compare(this.winRate, o.winRate);
		}
        
        public String toString() {
            return "Person[id= " + id + " winRate= " + winRate + " cnt= " + cnt + " weight= " + weight + "\n";
        }
    }

}
