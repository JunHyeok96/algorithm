import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int answer =0;
        Arrays.sort(citations);
        for(int i = citations[citations.length-1]; i>-1; i--){
            final int item = i;
            long h1 = Arrays.stream(citations).filter(j ->  item<= j).count();
            long h2 = Arrays.stream(citations).filter(j ->  item>= j).count();
            if(h1 >= i && h2<=i){
                answer = i;
                break;
            }
        }
        return answer;
    }
}