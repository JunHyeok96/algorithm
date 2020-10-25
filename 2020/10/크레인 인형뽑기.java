import java.util.List;
import java.util.ArrayList;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        List<Integer> bucket = new ArrayList<>();
        for(int move : moves){
            for(int []item : board){
                if(item[move-1] != 0){
                    if(bucket.size() > 0 && bucket.get(bucket.size()-1) == item[move-1]){
                        bucket.remove(bucket.size()-1);
                        answer+=2;
                    } else{
                        bucket.add(item[move-1]);
                    }
                    item[move-1]=0;
                    break;
                }
            }
        }
        return answer;
    }
}