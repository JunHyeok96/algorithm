import java.util.*;

class Solution {
    public int solution(int n, int m, int[][] edge_list, int k, int[] gps_log) {
        int answer = 0;
        int dp[][] = new int[k][n+1];
        final int INF = 1000000;
        for(int[] dpRow : dp){
            Arrays.fill(dpRow, INF);
        }
        List<List<Integer>> list = new ArrayList<>();
        for(int i=0; i<=n; i++){
            list.add(new ArrayList<Integer>());
        }
        for(int[] edge : edge_list){
            list.get(edge[0]).add(edge[1]);
            list.get(edge[1]).add(edge[0]);
        }
        dp[0][gps_log[0]] = 0;
        for(int i = 1; i < k; i++){
            for(int j = 1; j <= n; j++){
                for(int node : list.get(j)){
                    dp[i][j] = Math.min(dp[i][j], dp[i-1][node]);   
                }
                dp[i][j] += j == gps_log[i] ? 0 : 1;
            }
        }
        if(dp[k-1][gps_log[k-1]] >= INF){
            return -1;
        }
        return dp[k-1][gps_log[k-1]];
    }
}