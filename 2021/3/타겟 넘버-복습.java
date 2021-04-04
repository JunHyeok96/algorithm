import java.util.*;

class Solution {
    int answer = 0;
    int target;
    public int solution(int[] numbers, int target) {
        this.target = target;
        search(0, numbers, 0);
        return answer;
    }
    
    public void search(int result, int[] numbers, int depth){
        if(depth == numbers.length){
            if(result == target){
                answer++;
             }
            return;
        }
        search(result + numbers[depth], numbers, depth+1);
        search(result - numbers[depth], numbers, depth+1);
    }
}