class Solution {
    public int solution(int n, int[][] results) {
        int answer = 0;
        boolean[][] check = new boolean[n+1][n+1];
        for(int[] result : results){
            check[result[0]][result[1]] = true;
        }
        for(int k=1; k<= n; k++){
            for(int i=1; i<= n; i++){
                for(int j=1; j<=n; j++){
                    if(check[i][k] && check[k][j]){
                        check[i][j] = true;
                    }
                }
            }
        }
        for(int i=1; i<=n; i++){
            int sum = 0;
            for(int j=1; j<=n; j++){
                sum = check[i][j] || check[j][i] ? sum+1 : sum;
            }
            answer = sum == n-1 ? answer+1 : answer;
        }
        return answer;
    }
}