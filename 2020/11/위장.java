import java.util.HashMap;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String, Integer>map = new HashMap<>();
        for(String[] item : clothes) map.put(item[1], map.getOrDefault(item[1], 0) + 1);
        for(String key: map.keySet()) answer = answer*(map.get(key)+1);
        return answer -1;
    }
}