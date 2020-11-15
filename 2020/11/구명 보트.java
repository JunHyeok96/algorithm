import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        Arrays.sort(people);
        int end = people.length -1;
        int start = 0;
        int answer = 0;
        while(end >= start){
            if(people[start] + people[end] <= limit){
                start++;
            }
            end--;
            answer += 1; 
        }
        return answer;
    }
}