import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> answer = new ArrayList<>();
        int idx = 0;
        for(int day=1; idx < speeds.length; day++){
            if(day * speeds[idx] + progresses[idx]>=100){
                int count = 0;
                while(idx < speeds.length&& day * speeds[idx] + progresses[idx] >=100){
                    idx++;
                    count += 1;
                }   
                answer.add(count);
                count = 0;
            }
       }
        return answer.stream().mapToInt(i->i.intValue()).toArray();
    }
}