import java.util.*;
class Solution {
    public String solution(int n, int t, int m, String[] timetable) {
        String answer = "";
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int[] busArr = new int[n];
        int last_time = 0;
        for(int i = 0; i < n; i++){
            busArr[i] = 9 * 60 + t * i;
        }
        for(String time : timetable){
            if(busArr[n-1] >= TimeToInt(time)){
                pq.offer(TimeToInt(time));
            }
        }        
        int idx=0;
        for(int i=0; i < n ; i++){
            int count = 0;
            while(!pq.isEmpty() && busArr[i] >= pq.peek() && count < m){
                last_time = pq.poll();
                count++;
            }
            if(i == n - 1 && count == m){
                return intToTime(last_time - 1);
            }else if(i == n-1 && count < m){
                return intToTime(busArr[n-1]);
            }
        }
        return answer;
    }
    
    public int TimeToInt(String stringTime){
        int time = Integer.parseInt(stringTime.split(":")[0]) * 60 
            + Integer.parseInt(stringTime.split(":")[1]);
        return time;
    }

    public String intToTime(int intTime){
        return String.format("%02d",intTime/60) 
            + ":" 
            + String.format("%02d",intTime%60);
    }
}