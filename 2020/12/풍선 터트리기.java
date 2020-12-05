import java.util.*;
class Solution {
    public int solution(int[] a) {
        int answer = 2; 
        int l = a[0], r = a[a.length-1];
        for (int i = 1; i < a.length-1; i++) { 
            if(l > a[i]) {
                l = a[i]; 
                answer++;
            }
            if(r > a[a.length-1-i]) {
                r = a[a.length-1-i];
                answer++;
            }
        }

        return l ==r ? answer-1 : answer; 
    }
}