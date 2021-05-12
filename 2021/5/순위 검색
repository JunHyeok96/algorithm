import java.util.*;

class Solution {
    
    Map<String, ArrayList<Integer>> map = new HashMap<>();
    
    public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];
        for(String s : info){
            makeKey(s);
        }
        for(String key : map.keySet()){
            Collections.sort(map.get(key));
        }
        int idx = 0;
        for(String condition : query){
            String[] conditionArr = condition.split(" ");
            String key = conditionArr[0] + conditionArr[2] + conditionArr[4] + conditionArr[6];
            int score = Integer.parseInt(conditionArr[7]);
            if(!map.containsKey(key)){
                answer[idx++] = 0;
                continue;
            }
            answer[idx++] = binarySearch(map.get(key), score);
        }
        return answer;
    }
    
    public void makeKey(String info){
        String[] infoArr = info.split(" ");
        String[] languages = new String[]{infoArr[0], "-"};
        String[] positions = new String[]{infoArr[1], "-"};
        String[] careers = new String[]{infoArr[2], "-"};
        String[] soulFoods = new String[]{infoArr[3], "-"};
        int score = Integer.parseInt(infoArr[4]);
        for(String language : languages){
            for(String position : positions){
                for(String career : careers){
                    for(String soulFood : soulFoods){
                        String key = language + position + career + soulFood;
                        map.putIfAbsent(key, new ArrayList<Integer>());
                        map.get(key).add(score);
                    }
                }
            }
        }
    }
    
    public int binarySearch(List<Integer> arr, int score){
        int start = 0;
        int end = arr.size();
        while(end > start){
            int mid = (start + end)/2;
            if(arr.get(mid) >= score){
                end = mid;
            }else{
                start = mid + 1;
            }
        }
        return arr.size() - start;
    }
}