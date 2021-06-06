import java.util.*;

class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        int idx=0;
        for(long number : numbers){
            if(number % 2 == 0){
                answer[idx++] = number + 1;
            }else{
                String binary = Long.toBinaryString(number);
                char[] arr = binary.toCharArray();
                if(!binary.contains("0")){
                    answer[idx++] = Long.parseLong("10" + binary.substring(1), 2);
                }else{
                    int lastZeroIdx = binary.lastIndexOf("0");
                    arr[lastZeroIdx] = '1';
                    arr[lastZeroIdx + 1] = '0';
                    answer[idx++] = Long.parseLong(new String(arr), 2);
                }
            }
        } 
        return answer;
    }
        
}