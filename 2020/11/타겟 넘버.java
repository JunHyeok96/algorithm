import java.util.*;

class Solution {
    int answer = 0;
    public int solution(int[] numbers, int target) {
        search(0, numbers, 0, target);
        return answer;
    }
    public void search(int value, int[] numbers, int idx, int target){
        if(idx==numbers.length){
            if(value == target) answer+=1;
            return;
        }
        search(value+numbers[idx], numbers, idx+1, target);
        search(value-numbers[idx], numbers, idx+1, target);
    }
}