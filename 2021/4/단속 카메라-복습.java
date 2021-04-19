import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        int answer = 0;
        int cameraPosition = -30000;
        Arrays.sort(routes, (i1, i2) -> i1[1] - i2[1]);
        for(int[] route : routes){
            if(cameraPosition < route[0]){
                cameraPosition = route[1];
                answer++;
            }
        }
        return answer;
    }
}