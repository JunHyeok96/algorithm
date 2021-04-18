import java.util.*;

class Solution {
    
    private List<Integer> visited = new ArrayList<>();
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        for(int i=0; i < n; i++){
            if(!visited.contains(i)){
                dfs(makeGraph(computers), i);
                answer++;
            }
        }
        return answer;
    }
    
    private Map<Integer, List<Integer>> makeGraph(int[][] computers){
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i=0; i < computers.length; i++){
            map.put(i, new ArrayList<Integer>());
            for(int j=0; j < computers[i].length; j++){
                if(i!=j && computers[i][j] == 1) map.get(i).add(j);
            }
        }
        return map;
    }
    
    private void dfs(Map<Integer, List<Integer>> graph, int start){
        Stack<Integer> stack = new Stack<>();
        stack.push(start);
        while(!stack.isEmpty()){
            int node = stack.pop();
            if(!visited.contains(node)){
                visited.add(node);
                stack.addAll(graph.get(node));
            }
        }
    }
}