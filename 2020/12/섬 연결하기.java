import java.util.*;

class Solution {
    Stack<Integer> skip = new Stack<>();
    public int solution(int n, int[][] costs) {
        Arrays.sort(costs, (i1, i2) -> i2[2] - i1[2]);
        int answer = 0;
        int start = 0;
        while(start < costs.length){
            skip.push(start);
            boolean complete = false;
            for(int i=0; i< n; i++){
                if(isComplete(mkgraph(costs), n, i)){
                    complete = true;
                    break;
                };
            }
            if(complete == false){
                skip.pop();
            }
            start++;
        }
        for(int i=0; i < costs.length; i++){
            if(skip.contains(i)){
                continue;
            }
            answer+=costs[i][2];
        }
        return answer;
    }
    
    public boolean isComplete(Map<Integer, List<Integer>> map, int n, int start){
        if(!map.containsKey(start)){
            return false;
        }
        Stack<Integer> toGo = new Stack<Integer>();
        List<Integer> visited = new ArrayList<>();
        toGo.push(start);
        while(!toGo.isEmpty()){
            int node = toGo.pop();
            if(!visited.contains(node)){
                visited.add(node);
                if(map.containsKey(node)){
                    toGo.addAll(map.get(node));
                }
                map.remove(node);
            }
        }
        return visited.size() == n;
    }
    
    public Map<Integer, List<Integer>> mkgraph(int [][] costs){
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i=0; i < costs.length; i++){
            if(skip.contains(i)){
                continue;
            }
            if(!map.containsKey(costs[i][0])){
                map.put(costs[i][0], new ArrayList<Integer>());
            }
            if(!map.containsKey(costs[i][1])){
                map.put(costs[i][1], new ArrayList<Integer>());
            }
            map.get(costs[i][0]).add(costs[i][1]);
            map.get(costs[i][1]).add(costs[i][0]);
        }
        return map;
    }
    
  
}