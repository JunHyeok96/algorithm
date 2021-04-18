import java.util.*;

class Solution {
        
    public int solution(String begin, String target, String[] words) {
        return bfs(makeGraph(words, begin), begin, target);
    }

    public Map<String, List<String>> makeGraph(String[] words, String begin){
        Map<String, List<String>> graph = new HashMap<>();
        List<String> list = new ArrayList<String>(Arrays.asList(words));
        list.add(begin);
        for(String word : list){
            graph.put(word, new ArrayList<String>());
            for(String compareWord : words){
                int diff = 0;
                if(word.equals(compareWord)) continue;
                for(int i=0; i < word.length(); i++){
                    diff = word.charAt(i) != compareWord.charAt(i) ? diff+1 : diff;
                }
                if(diff == 1) graph.get(word).add(compareWord);
            }
        }
        return graph;
    }

    public int bfs(Map<String, List<String>> graph, String start, String target){
        Queue<String> needToGo = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        Map<String, Integer> depth = new HashMap<>(); 
        depth.put(start, 0);
        needToGo.offer(start);
        while(!needToGo.isEmpty()){
            String node = needToGo.poll();
            if(visited.add(node)){
                if(graph.containsKey(node)){
                    if(graph.get(node).contains(target)){
                        return depth.get(node) + 1;
                    }
                    graph.get(node).forEach(i -> {
                        needToGo.add(i);
                        depth.put(i, depth.get(node) + 1); 
                    });
                }
            }
        }
        return 0;
    }
}