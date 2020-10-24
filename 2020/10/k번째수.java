import java.util.Arrays;
import java.util.List;
import java.util.Comparator;
    
class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int idx=0;
        int[] answer = new int[commands.length];
        for(int[] command : commands){
            int[] arr = Arrays.copyOfRange(array, command[0]-1,command[1]);
            Arrays.sort(arr);
            answer[idx++] = arr[command[2]-1];
        }
        return answer;
    }
}