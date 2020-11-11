import java.util.*;

class Solution {
    public int[] solution(int brown, int yellow) {
        for(int yellow_row = 1; ; yellow_row++){
            for(int yellow_col = 1; yellow_col <= yellow_row; yellow_col++){
                if(yellow_col * yellow_row == yellow){
                    if((yellow_col+2)*(yellow_row+2) - yellow == brown)
                        return new int[]{yellow_row+2, yellow_col+2};
                }
            }
        }
       
    }
}