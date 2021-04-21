import java.util.*;

class Solution {
    public int solution(int n, int[][] costs) {
        int answer = 0;
        Arrays.sort(costs, (i1, i2) -> i2[2] - i1[2]);
        boolean[][] isConnect = new boolean[n][n];
        for(int[] cost : costs){
            isConnect[cost[0]][cost[1]] = true;
            isConnect[cost[1]][cost[0]] = true;
        }
        for(int[] cost : costs){
            isConnect[cost[0]][cost[1]] = false;
            isConnect[cost[1]][cost[0]] = false;
            if(!dfs(isConnect.clone(), cost[0], n)){
                isConnect[cost[0]][cost[1]] = true;
                isConnect[cost[1]][cost[0]] = true;
                answer += cost[2];
            }
        }
        return answer;
    }
    
    public boolean dfs(boolean[][] isConnect, int start, int n){
        Stack<Integer> needToGo = new Stack<>();
        Set<Integer> visited = new HashSet<>();
        needToGo.push(start);
        while(!needToGo.isEmpty()){
            int node = needToGo.pop();
            if(visited.add(node)){
               for(int i=0; i < isConnect[node].length; i++){
                   if(isConnect[node][i]){
                       needToGo.push(i);
                   }
               } 
            }
        }
        return visited.size() == n;
    }
}

//

import java.util.*;

class Solution {
    public int solution(int n, int[][] costs) {
        int answer = 0;
        Arrays.sort(costs, (i1, i2) -> i1[2] - i2[2]);
        int[] arr = new int[n];
        for(int i=0; i < n; i++){
            arr[i] = i;
        }
        for(int[] cost : costs){
            if(find(arr, cost[0]) != find(arr, cost[1])){
                unite(arr, cost[0], cost[1]);
                answer += cost[2];
            }
        }
        return answer;
    }
    
    public int find(int[] arr, int x){
        if(arr[x] == x){
            return x;
        }
        return find(arr, arr[x]);
    }
    
    public void unite(int[] arr, int x, int y){
        int x1 = find(arr, x);
        int y1 = find(arr, y);
        arr[y1] = x1;
    }
}