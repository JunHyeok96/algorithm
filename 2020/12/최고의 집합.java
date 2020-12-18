import java.util.*;

class Solution {
    public int[] solution(int n, int s) {
        int[] answer = new int[n];
        int div = s/n;
        int remain = s%n;
        int buf = remain;
        if(div == 0){
            return new int[]{-1};
        }
        for(int i=0; i<n ; i++){
            answer[i] = remain > i ? div + 1 : div;
        }
        Arrays.sort(answer);
        return answer;
    }
   
}