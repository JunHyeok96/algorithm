import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        int time =0; int start = -1; int count = 0; int answer = 0;
        int n = jobs.length;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        while(count < n){
            for(int[] job : jobs){
                if(start< job[0] && job[0] <= time){
                    pq.offer(job[1]); //작업 추가
                    answer += time - job[0]; //기다린시간 더하기
                }
            }
            if(!pq.isEmpty()){
                answer += pq.peek() * pq.size(); //작업 + 작업 대기시간 추가
                count +=1; //작업 완료
                start = time; //작업 시작 시간 갱신
                time += pq.poll(); //현재 시간 갱신
            }else{
                time++;
            }
        }
        return answer/n;
    }
}