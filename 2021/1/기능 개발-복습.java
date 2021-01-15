import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> deploys = new ArrayList<>();
        int idx = 0;
        int day = 1;
        while(idx < progresses.length){
            int count = 0;
            while(idx < progresses.length && progresses[idx] + speeds[idx] * day >= 100){
                idx++;
                count++;
            }
            day++;
            if(count > 0){
                deploys.add(count);
            }
        }
        return deploys.stream().mapToInt(i -> i).toArray();
    }
}