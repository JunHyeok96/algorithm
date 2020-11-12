import java.util.*;

class Solution {
    List<List<String>> roots = new ArrayList<>();
    public String[] solution(String[][] tickets) {
        String[] answer = {};
        boolean[] visited = new boolean[tickets.length];
        dfs(tickets, "ICN", visited, new Stack<String>());
        Collections.sort(roots, (i1, i2) -> {
            String s1 = i1.toString(); String s2 = i2.toString();
            return s1.compareTo(s2);
        });
        
        return Arrays.copyOf(roots.get(0).toArray(), roots.get(0).size(), String[].class);
    }
    
    public void dfs(String[][] tickets, String start, boolean visited[], Stack<String> root){        
        if(root.size() == tickets.length){
            root.add(start);  
            roots.add(root);    
            return;
        }
        int i=0;
        for(String[] ticket : tickets){
            if(visited[i] == false && ticket[0].equals(start)){
                visited[i]=true;
                Stack<String> stack = new Stack<>();
                stack.addAll(root);
                stack.push(start);
                dfs(tickets, ticket[1], visited, stack);
                visited[i]=false;
            }
            i++;
        }
    }
}