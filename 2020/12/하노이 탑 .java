import java.util.*;

class Solution {
    List<int[]> arrList = new ArrayList<>();
    public int[][] solution(int n) {
        move(n, 1, 2, 3);
        int[][] answer = new int[arrList.size()][2];
        int idx=0;
        for(int[] array : arrList){
            answer[idx++] = array;
        }
        return answer;
    }
    
    public void move(int depth, int start, int via, int end){
        if(depth == 1){
            arrList.add(new int[]{start,end});
            return;
        }
        move(depth-1, start, end, via); 
        arrList.add(new int[]{start, end});
        move(depth-1, via, start, end);
    }
}