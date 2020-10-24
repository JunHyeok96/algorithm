import java.util.HashMap;

class Solution {
    public String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> hm = new HashMap<>();
        for(String person : participant) hm.put(person, hm.getOrDefault(person, 0) + 1);
        for(String person : completion) hm.put(person, hm.get(person) - 1);
        for(String key : hm.keySet()){
            if(hm.get(key) !=0){
                return key;
            }
        }
        return "";
    }
}