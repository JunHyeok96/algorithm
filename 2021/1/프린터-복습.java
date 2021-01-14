import java.util.*;

class Solution {
    
    public int solution(int[] priorities, int location) {
        int answer = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i< priorities.length; i++){
            map.put(i, priorities[i]);
        }
        List<Integer> prioritiesList = new ArrayList<>(map.values());
        Collections.sort(prioritiesList, (i1, i2) -> i2 - i1);
        int idx=0;
        while(prioritiesList.size() > 0){
            if(map.containsKey(idx) && map.get(idx) == prioritiesList.get(0)){
                map.remove(idx);
                prioritiesList.remove(0);
                answer++;
                if(idx == location){
                    return answer;
                }
            }else{
                idx = (idx+1)%priorities.length;
            }
        }
        return answer;
    }
}