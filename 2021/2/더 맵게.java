import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int num : scoville){
            pq.offer(num);
        }
        while(pq.size() > 1 && pq.peek() < K){
            int first = pq.poll();
            int second = pq.poll();
            int new_food = first + second*2;
            pq.offer(new_food);
            answer++;
        }
        return pq.peek() >= K ? answer : -1;
    }
}