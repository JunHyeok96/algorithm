import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        int done = 0;
        int time = 0;
        int end = -1;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        while(done < jobs.length){
            for(int[] job : jobs){
                if(end < job[0] && job[0] <= time){
                    pq.offer(job[1]);
                    answer += time - job[0];
                }
            }
            if(pq.size() > 0){
                answer += pq.peek() * pq.size();
                end = time;
                time += pq.poll();
                done++;
            }else{
                time++;
            }   
        }
        return answer/jobs.length;
    }
}