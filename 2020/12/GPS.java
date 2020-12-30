import java.util.*;

class Solution {
    public int solution(int n, int m, int[][] edge_list, int k, int[] gps_log) {
        int answer = 0;
        int INF = Integer.MAX_VALUE;
        int[][] dp = new int[k][n+1];
        List<List<Integer>> list = new ArrayList<>();
        for(int i=0; i<n+1; i++){
            list.add(new ArrayList<Integer>(Arrays.asList(i)));
        }
        Arrays.stream(edge_list).forEach(i ->{
            list.get(i[0]).add(i[1]);
            list.get(i[1]).add(i[0]);
        });
        Arrays.stream(dp).forEach(i -> Arrays.fill(i, INF));
        dp[0][gps_log[0]] = 0;
        for(int i=1; i < k; i++){
            for(int j=1; j<n+1; j++){
                for(int node : list.get(j)){
                   dp[i][j] = Math.min(dp[i][j], dp[i-1][node]);
                }
                if(dp[i][j] != INF){
                    dp[i][j] += j == gps_log[i] ? 0 : 1;
                }
            }
        }
        return dp[k-1][gps_log[k-1]] == INF ? -1 : dp[k-1][gps_log[k-1]];
    }
}