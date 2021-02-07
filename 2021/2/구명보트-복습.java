import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);
        int start_idx=0;
        for(int i= people.length -1; i >= 0 && start_idx <= i; i--){
            if(people[i] + people[start_idx] <= limit){
                start_idx++;
            }
            answer++;
        }
        return answer;
    }
}