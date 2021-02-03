import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        List<String> list = new ArrayList<>();
        for(int num : numbers){
            list.add(Integer.toString(num));
        }
        Collections.sort(list, (s1, s2) -> (s2+s1).compareTo(s1+s2));
        StringBuilder sb = new StringBuilder();
        for(String s : list) sb.append(s);
        answer = sb.toString();
        return answer.charAt(0) != '0' ? answer : "0";
    }
}