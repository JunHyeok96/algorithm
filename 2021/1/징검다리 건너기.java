import java.util.*;

class Solution {
    public int solution(int[] stones, int k) {
        int answer = 0;
        int max = 0;
        int min = Integer.MAX_VALUE;
        for(int stone : stones){
            min = Math.min(stone, min);
            max = Math.max(stone, max);
        }
        while(max >= min){
            int mid = (min + max)/2;
            if(isSuccess(stones, k, mid)){
                min = mid + 1;
                answer = mid;
            }else{
                max = mid - 1;
            }
        }
        return answer;
    }
    
    public boolean isSuccess(int[] stones, int k, int friends){
        int passCnt = 0;
        for(int stone : stones){
            if(stone < friends){
                passCnt++;
            }else{
                passCnt=0;
            }
            if(passCnt >= k){
                return false;
            }
        }
        return true;
    }
}