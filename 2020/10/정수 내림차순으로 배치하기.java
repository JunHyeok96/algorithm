import java.util.Arrays;

class Solution {
    public long solution(long n) {
        char[] number = Long.toString(n).toCharArray();
        Arrays.sort(number);
        long answer =  Long.parseLong(new StringBuffer(new String(number)).reverse().toString());
        return answer;
    }
}