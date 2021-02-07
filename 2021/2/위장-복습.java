import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        Map<String, Set<String>> map = new HashMap<>();
        int answer = 1;
        for(String[] cloth : clothes) {
            map.put(cloth[1], map.getOrDefault(cloth[1], new HashSet<String>()));
            map.get(cloth[1]).add(cloth[0]);
        }
        for(String key : map.keySet()){
            answer *= map.get(key).size() + 1;
        }
        return answer-1;
    }
}