import java.util.*;

class Solution {
    public String solution(int[] numbers) {
       String answer = "";
        List<String> list = new ArrayList<>();
        for(int i : numbers) list.add(String.valueOf(i));
        Collections.sort(list, (i1, i2) ->(i2+i1).compareTo(i1+i2));
        answer = String.join("", list);
        return answer.charAt(0) == '0' ? "0" : answer;
    }
}