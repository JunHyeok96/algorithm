import java.util.*;
class Solution {
    public int[] solution(String msg) {
        List<Integer> answer = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        for(int i=0; i<26; i++){
            map.put(Character.toString('A' + i),  i+1);
        }
        String[] text = msg.split("");
        StringBuilder sb= new StringBuilder();
        for(int i=0; i<text.length; i++){
            int idx=0;
            while(i + idx < text.length && map.containsKey(sb.toString() + text[i + idx])){
                sb.append(text[i + idx]);
                idx++;
            }
            String input = sb.toString();
            if(map.containsKey(input)){
                answer.add(map.get(input));
            }
            if(i + idx < text.length && !map.containsKey(input + text[i + idx])){
                sb.append(text[i + idx]);
                map.put(sb.toString(), map.size() + 1);
            }
            if(idx > 1){
                i += idx - 1;
            }
            sb.setLength(0);
        }
        return answer.stream().mapToInt(i -> i.intValue()).toArray();
    }
}