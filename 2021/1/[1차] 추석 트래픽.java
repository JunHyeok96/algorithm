class Solution {
    public int solution(String[] lines) {
        int answer = 0;
        int[][] times = new int[lines.length][2];
        int idx = 0;
        for(String line : lines){
            int time = timeToInt(line);
            int duration = (int)Math.ceil(Float.parseFloat(line.split(" ")[2].split("s")[0])*1000);
            if(duration > 3000){
                continue;
            }
            times[idx++] = new int[]{(int)Math.max(0, time - duration + 1), time};
        }
        for(int i =0; i< times.length; i++){
            int start_count = 0;
            int end_count = 0;
            for(int j=0; j< times.length; j++){
                if(times[j][1] >= times[i][0] && times[j][1] < times[i][0]+1000) {
                    start_count++;
                } else if(times[j][0] >= times[i][0] && times[j][0] < times[i][0]+1000) {
                    start_count++;
                } else if(times[j][0] <= times[i][0] && times[j][1] > times[i][0]+1000) {
                    start_count++;                                        
                } 
                
                if(times[j][1] > times[i][0] - 1000 && times[j][1] <= times[i][0]) {
                    end_count++;
                } else if(times[j][0] > times[i][0] - 1000 && times[j][0] <= times[i][0]) {
                    end_count++;
                } else if(times[j][0] < times[i][0] - 1000 && times[j][1] >= times[i][0]) {
                    end_count++;                                        
                } 
            }
            answer = Math.max(answer, Math.max(start_count, end_count));
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