import java.util.*;

class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] check = new boolean[n];
        for(int i=0; i<n; i++){
            if(!check[i]){
                dfs(computers, check, i);
                answer++;
            }
        }
        return answer;
    }
    
    public void dfs(int[][] computers, boolean[] check, int start){
        for(int i=0; i<check.length; i++){
            if(computers[start][i] ==1 && !check[i]){
                check[i]=true;
                dfs(computers, check, i);
            }
        }
    }
}