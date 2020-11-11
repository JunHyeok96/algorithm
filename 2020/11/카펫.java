import java.util.*;

class Solution {
    public int[] solution(int brown, int yellow) {
        for(int yellow_col = 1; ; yellow_col++){
            int yellow_row = yellow / yellow_col;
            if(yellow_col * yellow_row == yellow){
               if((yellow_col+2)*(yellow_row+2) - yellow == brown)
                  return new int[]{yellow_col+2, yellow_row+2};
                }
            }
    }
}