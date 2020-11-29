import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        Queue<String> queue = new LinkedList<>();
        int answer = 0;
        for(String city : cities){
            String cityToLower = city.toLowerCase();
            answer += cache(queue, cityToLower, cacheSize);
        }
        return answer;
    }

    public int cache(Queue<String> queue, String city, int cacheSize){
        if(cacheSize==0){
            return 5;
        }else if(queue.contains(city)){
            String cacheCity = city;
            queue.remove(city);
            queue.offer(city);
            return 1;
        }else if(queue.size() < cacheSize){
            queue.offer(city);
            return 5;
        } else{
            queue.poll();
            queue.offer(city);
            return 5;
        }    
    }
}