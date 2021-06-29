import java.util.*;

class Solution {
    int[] arr;
    
    public int solution(int n, int[][] costs) {
        arr = new int[n];
        for(int i=0; i<n; i++) arr[i] = i;
        int answer = 0;
        Arrays.sort(costs, (c1, c2)-> c1[2] - c2[2]);
        int edgeCount = 0;
        for(int[] cost : costs){
            if(edgeCount == n -1){
                break;
            }
            if(find(cost[0]) != find(cost[1])){
                union(cost[0], cost[1]);
                answer += cost[2];
                edgeCount++;
            }
        }
        return answer;
    }
    
    public int find(int node){
        if(arr[node] == node){
            return node;
        }
        return arr[node] = find(arr[node]);
    }
    
    public void union(int node1, int node2){
        int x = find(node1);
        int y = find(node2);
        arr[y] = x;
    }
}

import java.util.*;

class Solution {    
    public int solution(int n, int[][] costs) {
        int answer = 0;
        boolean[] visited = new boolean[n];
        int count = 0;
        Map<Integer, List<Node>> map = graph(costs);
        PriorityQueue<Node> pq = new PriorityQueue<Node>((i1, i2) -> i1.weight - i2.weight);
        pq.addAll(map.get(0));
        visited[0] = true;
        while(!pq.isEmpty()){
            Node cur = pq.poll();
            if(!visited[cur.dst]){
                visited[cur.dst] = true;
                answer += cur.weight;
                pq.addAll(map.get(cur.dst));
            }
        }
        return answer;
    }
   
    public Map<Integer, List<Node>> graph(int[][] costs){
        Map<Integer, List<Node>> map = new HashMap<>();
        for(int[] cost : costs){
            map.putIfAbsent(cost[0], new ArrayList<Node>());
            map.putIfAbsent(cost[1], new ArrayList<Node>());
            map.get(cost[0]).add(new Node(cost[1], cost[2]));
            map.get(cost[1]).add(new Node(cost[0], cost[2]));
        }
        return map;
    }
}

class Node{
    int dst;
    int weight;
    
    public Node(int dst, int weight){
        this.dst = dst;
        this.weight = weight;
    }
}