import java.util.*;

class Solution {
    public int solution(String[] lines) {
        int answer = 1;
        int[] start = new int[lines.length];
        int[] end = new int[lines.length];
        int idx = 0;
        for(String line : lines){
            int time = timeToInt(line);
            int duration = (int)Math.ceil(Float.parseFloat(line.split(" ")[2].split("s")[0])*1000);
            if(duration > 3000){
                continue;
            }
            start[idx] = (int)Math.max(0, time - duration + 1);
            end[idx++] = time;
        }
        Arrays.sort(start);
        Arrays.sort(end);
        int count=0;
        for(int i=0,j=0;i<start.length;i++){
            count++;
            if(end[j]+1000<=start[i]){
                j++;
                count--;
            }
            if(count>answer){
                answer=count;
            }
        }
        return answer;
    }
    public int timeToInt(String line){
        String[] time = line.split(" ")[1].split(":");
        int hour = 60*60* (int)(Float.parseFloat(time[0]) * 1000);
        int minutes = 60*(int)(Float.parseFloat(time[1]) * 1000);
        int second = (int)Math.ceil(Float.parseFloat(time[2]) * 1000);
        return hour + minutes + second;
    }
}