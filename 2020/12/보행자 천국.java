class Solution {
    int MOD = 20170805;
    public int solution(int m, int n, int[][] cityMap) {
        int[][][] map = new int[m+1][n+1][2];
        map[1][1][0] = 1; map[1][1][1] = 1;
        for(int i=1; i<= m; i++){
            for(int j=1; j<= n; j++){
                if(cityMap[i-1][j-1]==0){
                    map[i][j][0] += (map[i-1][j][0] + map[i][j-1][1])%MOD;
                    map[i][j][1] += (map[i-1][j][0] + map[i][j-1][1])%MOD;
                }else if(cityMap[i-1][j-1]==1){
                    map[i][j][0] = 0;
                    map[i][j][1] = 0;
                }else if(cityMap[i-1][j-1]==2){
                    map[i][j][0] = map[i-1][j][0]%MOD;
                    map[i][j][1] = map[i][j-1][1]%MOD;                  
                }
            }
        }
        return map[m][n][0]%MOD;
    }
}