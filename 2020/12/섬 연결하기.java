import java.util.*;

class Solution {
    public int solution(int n, int[][] costs) {
        int answer = 0;
        int[] island = new int[n];
        for(int i=0; i < n; i++){
            island[i] = i;
        }
        Arrays.sort(costs, (i1, i2) -> i1[2] - i2[2]);
        for(int i=0; i< costs.length; i++){
            if(find(island, costs[i][0]) != find(island, costs[i][1])){
                merge(island, costs[i][0], costs[i][1]);
                answer += costs[i][2];
            }
        }
        
        return answer;
    }
    
    public int find(int[] island, int x){
        if(island[x] == x){
            return x;
        }
        return find(island, island[x]);
    }
    
    public void merge(int[] island, int x, int y){
        int parentX = find(island, x);
        int parentY = find(island, y);
        island[parentX] = parentY;
    }
}