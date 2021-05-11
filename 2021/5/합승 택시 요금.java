import java.util.*;

class Solution {
    Map<Integer, List<Edge>> map;
    
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = Integer.MAX_VALUE;
        map = new HashMap<>();
        Arrays.stream(fares).forEach(fare -> {
            map.put(fare[0], new ArrayList<>());
            map.put(fare[1], new ArrayList<>());
        });
        Arrays.stream(fares).forEach(fare -> {
            map.get(fare[0]).add(new Edge(fare[1], fare[2]));
            map.get(fare[1]).add(new Edge(fare[0], fare[2]));
        });
        for(int[] fare : fares){
            map.putIfAbsent(fare[0], new ArrayList<>());
            map.putIfAbsent(fare[1], new ArrayList<>());
            map.get(fare[0]).add(new Edge(fare[1], fare[2]));
            map.get(fare[1]).add(new Edge(fare[0], fare[2]));
        }
        int[] startA = new int[n+1];
        int[] startB = new int[n+1];
        int[] startS = new int[n+1];
        Arrays.fill(startA, 100000 * 200 +1);
        Arrays.fill(startB, 100000 * 200 +1);
        Arrays.fill(startS, 100000 * 200 +1);
        dijkstra(s, startS);
        dijkstra(a, startA);
        dijkstra(b, startB);
        for(int i=0; i < n+1; i++){
            answer = Math.min(answer, startS[i] + startA[i] + startB[i]);
        }
        return answer;
    }
    
    public void dijkstra(int start, int[] dp){
        PriorityQueue<Edge> pq = new PriorityQueue<>((e1, e2) -> e1.weight - e2.weight);
        pq.offer(new Edge(start, 0));
        dp[start] = 0;
        while(!pq.isEmpty()){
            Edge path = pq.poll();
            for(Edge edge : map.get(path.end)){
                if(dp[edge.end] > dp[path.end] + edge.weight){
                    dp[edge.end] = dp[path.end] + edge.weight;
                    pq.offer(edge);
                }
            }
        }
    }
}

class Edge{
    int end;
    int weight;
    
    public Edge(int end, int weight){
        this.end = end;
        this.weight = weight;
    }
}