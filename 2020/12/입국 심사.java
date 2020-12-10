import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        Arrays.sort(times);
        long answer = Long.MAX_VALUE;
        long start =1;
        long end = (long)times[times.length - 1] * n;
        while(start <= end){
            long mid = (start + end)/ 2;
            long sum = 0;
            for(int time : times){
                sum += mid/time;
            }
            if(sum >= n){
                answer = mid < answer ? mid : answer;
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }
        return answer;
    }
}
