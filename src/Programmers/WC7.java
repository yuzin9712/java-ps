package Programmers;

import java.util.HashSet;
import java.util.Set;

public class WC7 {
	static Set<Integer> in;
    public int[] solution(int[] enter, int[] leave) {
        int[] answer;
        //퇴실 먼저하고 입실확인
        in = new HashSet<Integer>();

        int size = enter.length;
        answer = new int[size];

        int e = 0, l = 0;

        while(e < size && l < size) {
            //이미 들어와있는 애가 나가려고 하면 나가
            if(in.contains(leave[l])) {
                in.remove(leave[l]);
                l++;
                continue;
            }
            int newin = enter[e];

            answer[newin - 1] += in.size();

            for(Integer c : in) {
                answer[c - 1]++;
            }

            in.add(enter[e++]);
        }

        if(e < size) {
            for(int i = e; i < size; i++) {
                int newin = enter[i];
                answer[newin - 1] += in.size();

                for(Integer c : in) {
                    answer[c - 1]++;
                }

                in.add(enter[i]);
            }
        }


        return answer;
    }
}
