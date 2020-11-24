class Solution {
    int max_point = 0;
    int solution(int[][] land) {
        int buf = -1;
        for(int i=1; i<land.length; i++){
            land[i][0] += Math.max(land[i-1][1], Math.max(land[i-1][2], land[i-1][3]));
            land[i][1] += Math.max(land[i-1][0], Math.max(land[i-1][2], land[i-1][3]));
            land[i][2] += Math.max(land[i-1][1], Math.max(land[i-1][0], land[i-1][3]));
            land[i][3] += Math.max(land[i-1][1], Math.max(land[i-1][2], land[i-1][0]));
        }
        int x = Math.max(land[land.length-1][0], land[land.length-1][1]);
        int y = Math.max(land[land.length-1][2], land[land.length-1][3]);
        return Math.max(x, y);
    }
}