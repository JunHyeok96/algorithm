import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        Arrays.sort(times);
        long answer = Long.MAX_VALUE;
        long start = 0;
        long end = (long)times[times.length - 1] * n;
        while(start <= end){
            long mid = (start + end) /2;
            if(isComplete(n, times, mid)){
                end = mid - 1;
                answer = Math.min(answer, mid);
            }else{
                start = mid + 1; 
            }
        }
        return answer;
    }
    
    public boolean isComplete(int n, int[] times, long mid){
        long sum = 0;
        for(int time : times){
            sum += mid/time;
        }
        return n <= sum;
    }
}