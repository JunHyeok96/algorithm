import java.util.Arrays;
class Solution {
    public int solution(int[] d, int budget) {
        Arrays.sort(d);
        int answer = d.length;
        while(true){
            int sum = 0;
            for(int i = 0 ; i<answer; i++) sum+= d[i];
            if(sum > budget){            
                answer -=1;
            }else{
                break;
            }
        }
        return answer;
    }
}