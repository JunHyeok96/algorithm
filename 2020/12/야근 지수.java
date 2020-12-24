import java.util.*;
class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>((i1, i2) -> i2 - i1);
        for(int work : works) pq.offer(work);
        for(int i=0; i < n; i++){
            if(pq.isEmpty()){
                return 0;
            }
            int work = pq.poll() - 1;
            if(work > 0){
                pq.offer(work);
            }
        }
        for(int work : pq) answer += work * work;
        return answer;
    }
}