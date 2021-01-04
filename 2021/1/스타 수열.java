import java.util.*;
class Solution {
    public int solution(int[] a) {
        int answer = 0;
        if(a.length < 2){
            return answer;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for(int i : a) map.put(i, map.getOrDefault(i, 0) + 1);
        for(int key : map.keySet()){
            if(map.get(key) * 2 <= answer){
                continue;
            }
            int idx = 0;
            int count = 0;
            while(idx + 1 < a.length){
                if((a[idx] == key || a[idx+1] == key) && (a[idx] != a[idx+1])){
                    count +=2;
                    idx +=2;
                    continue;
                }
                idx+=1;
            }
            answer = Math.max(answer, count);
        }
        return answer;
    }
}