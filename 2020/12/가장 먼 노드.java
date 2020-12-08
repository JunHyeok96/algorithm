import java.util.*;

class Solution {
    public int solution(int n, int[][] edges) {
        int answer = 0;
        boolean[][] map = new boolean[n+1][n+1];
        for(int[] edge : edges) map[edge[0]][edge[1]] = map[edge[1]][edge[0]] = true;
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> visited = new ArrayList<>();
        int[] dist = new int[map.length];
        queue.offer(1);
        int maxDist = 0;
        while(!queue.isEmpty()){
            int node = queue.poll();
            if(!visited.contains(node)){
                visited.add(node);
                for(int i=1; i < map[node].length; i++){
                    if(dist[i] == 0 && map[node][i] && !visited.contains(i)){
                        dist[i] = dist[node] + 1;
                        queue.offer(i);
                        maxDist = Math.max(maxDist, dist[i]);
                    }
                }
            }
        }
        for(int d : dist) answer = d == maxDist ? answer+1 : answer;
        return answer;
    } 
}