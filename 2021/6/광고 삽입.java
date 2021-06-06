import java.util.*;

class Solution {
    public String solution(String play_time, String adv_time, String[] logs) {
        int answer = 0;
        int totalPlayTime = toSecond(play_time);
        int totalAdvTime = toSecond(adv_time);
        long[] totalTimeArr = new long[totalPlayTime + 1];
        for(String log : logs){
            String[] arr = log.split("-");
            totalTimeArr[toSecond(arr[0])]++;
            totalTimeArr[toSecond(arr[1])]--;
        }
        for(int i=1; i < totalPlayTime; i++) totalTimeArr[i] += totalTimeArr[i -1];
        for(int i=1; i < totalPlayTime; i++) totalTimeArr[i] += totalTimeArr[i -1];
        long max = totalTimeArr[totalAdvTime-1];
        for(int i=0; totalAdvTime + i <= totalPlayTime; i++){
            long temp = totalTimeArr[totalAdvTime+i] - totalTimeArr[i];
            if(max < temp){
                max = temp;
                answer = i + 1;
            };
        }
        return toStringTime(answer);
    }
    
    public int toSecond(String time){
        String[] arr = time.split(":");
        return Integer.parseInt(arr[0]) * 3600
            + Integer.parseInt(arr[1]) * 60 
            + Integer.parseInt(arr[2]);
    }
    
    public String toStringTime(int time){
        int hour = time/3600;
        int minutes = (time%3600)/60;
        int second = (time%60);
        return String.format("%02d:%02d:%02d", hour, minutes, second);
    }  
}