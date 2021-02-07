class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = {};
        int total = brown + yellow;
        for(int col = 1; 1 < total/col; col++){
            for(int row = 1; row <= col; row++){
                if(col*row == total){
                   if(col >= 3 && col * 2 + row * 2 - 4 == brown)
                       return new int[]{col, row};
                }
            }
        }
        return answer;
    }
}