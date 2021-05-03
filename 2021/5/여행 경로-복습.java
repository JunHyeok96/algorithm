import java.util.*;

class Solution {
    List<List<String>> roots = new ArrayList<>();
    public String[] solution(String[][] tickets) {
        String[] answer = {};
        boolean[] visited = new boolean[tickets.length];
        dfs(tickets, "ICN", visited, new Stack<String>());
        Collections.sort(roots, (s1, s2) -> s1.toString().compareTo(s2.toString()));
        return roots.get(0).toArray(new String[tickets.length + 1]);
    }

    public void dfs(String[][] tickets, String start, boolean visited[], Stack<String> root){     
        if(root.size() == tickets.length){
            root.push(start);  
            roots.add(new ArrayList<>(root));  
            root.pop();
            return;
        }
        int i=0;
        for(String[] ticket : tickets){
            if(visited[i] == false && ticket[0].equals(start)){
                root.push(start);
                visited[i] = true;
                dfs(tickets, ticket[1], visited, root);
                visited[i] = false;
                root.pop();
            }
            i++;
        }
    }
}