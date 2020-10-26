import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        Stack<Integer> answer = new Stack<>();
        for(int num : arr){
            if(!answer.empty() && answer.peek() == num){
                continue;
            }else{
                answer.push(num);
            }
        }
        return answer.stream().mapToInt(i->i.intValue()).toArray();
    }
}