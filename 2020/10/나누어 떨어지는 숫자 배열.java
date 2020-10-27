import java.util.Arrays;

class Solution {
    public int[] solution(int[] arr, int divisor) {
        int []answer =  Arrays.stream(arr).sorted().filter(factor -> factor % divisor == 0).toArray();
        if(answer.length > 0){
            return  answer;
        } else{
            answer = new int[1];
            answer[0] = -1;
            return answer;
        }
    }
}