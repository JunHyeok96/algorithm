import java.util.*;

class Solution {
    Map<String, Integer> map = new HashMap<>();
    public String[] solution(String[] orders, int[] course) {
        List<String> answer = new ArrayList<>();
        for(String order : orders){
            for(int num : course){
                char[] arr = order.toCharArray();
                Arrays.sort(arr);
                comb(num, 0, arr, 0, new char[num]);
            }
        }
        int[] count = new int[20];
        for(String key : map.keySet()){
            count[key.length()] = Math.max(map.get(key), count[key.length()]); 
        }
        for(int num : course){
            int max_value = 0;
            for(String key : map.keySet()){
                if(map.get(key) >= 2 && 
                   key.length() == num && 
                   count[key.length()] == map.get(key)){
                    answer.add(key);
                }
            }
        }
        Collections.sort(answer);
        return answer.toArray(String[] :: new);
    }

    public void comb(int num, int depth, char[] input, int idx, char[] result){
        if(num == idx){
            map.put(new String(result), map.getOrDefault(new String(result), 0) + 1);
            return;
        }
        if(depth == input.length){
            return;
        }
        comb(num, depth+1, input, idx, result);
        result[idx] = input[depth];
        comb(num, depth+1, input, idx+1, result);
    }
}