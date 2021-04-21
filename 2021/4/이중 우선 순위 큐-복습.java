import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = {};
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(String operation : operations){
            String[] arr = operation.split(" ");
            if(arr[0].equals("I")){
               pq.offer(Integer.parseInt(arr[1]));
            }else if(arr[0].equals("D")){
                if(Integer.parseInt(arr[1]) == -1 && !pq.isEmpty()){
                    pq.poll();
                }else if(Integer.parseInt(arr[1]) == 1 && !pq.isEmpty()){
                    pq.remove((Integer)Collections.max(pq));
                }
            }
        }
        return pq.isEmpty() ? new int[]{0,0} : new int[]{Collections.max(pq), pq.poll()};
    }
    
}