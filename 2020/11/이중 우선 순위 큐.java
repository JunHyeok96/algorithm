import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = {};
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(String operation : operations){
            String []value = operation.split(" ");
            if(value[0].equals("I")){
                pq.offer(Integer.parseInt(value[1]));
            }else if(value[0].equals("D") &&  value[1].equals("1")){
                if(!pq.isEmpty()){
                    int max = Collections.max(pq);
                    pq.remove(Integer.valueOf(max));
                }
            }else if(value[0].equals("D") &&  value[1].equals("-1")){
                if(!pq.isEmpty()){
                    pq.poll();
                }
            }
        }
        return pq.isEmpty() ? new int[]{0, 0}:  new int[]{Collections.max(pq), pq.poll()};
    }
}