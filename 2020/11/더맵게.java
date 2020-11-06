import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for(int scoville_value : scoville) heap.add(scoville_value);
        while(heap.peek() <= K){
            if(heap.size() == 1) return -1;
            int first_scoville = heap.poll();
            int second_scoville = heap.poll();
            heap.add(first_scoville + second_scoville*2);
            answer+=1;
        }
        return answer;
    }
}