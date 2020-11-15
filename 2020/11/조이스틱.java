import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(String name) {
        int length = name.length();
        int[] arr = new int[length];
        int a = 'A';
        int z = 'Z';
        int answer = 0;
        for(int i =0; i < length; i++){
            char target = name.charAt(i);
            arr[i] = Math.min(target - a, Math.abs(z - target + 1));
            answer += arr[i];
        }
        int idx = 0;
        while(IntStream.of(arr).sum()>0){
            int right = 0; int left = 0;
            while(arr[(idx + right) % length] == 0){
                right++;
            }
             while(arr[(idx - left) < 0 ?  length + (idx-left) % length : idx - left] == 0){
                left++;
            }
            System.out.println(right +" " + left);
            int shift = right >= left ? left : right; 
            idx = (right + idx) % length;
            arr[idx] = 0;
            answer += shift;
        }
            return answer;
    }
}