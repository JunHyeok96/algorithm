class Solution {
    final int POLL = 0;
    final int BO = 1;
    final int DEL = 0;
    final int NEW = 1;
    int n;
    boolean[][] poll;
    boolean[][] bo;
    public int[][] solution(int n, int[][] build_frame) {
        this.n = n;
        poll = new boolean[n+2][n+2];
        bo = new boolean[n+2][n+2];
        int count = 0;
        for(int[] frame : build_frame){
            int x = frame[0] + 1;
            int y = frame[1] + 1;
            int frameType = frame[2];
            int operation = frame[3];
            if(operation == NEW){
                if(frameType == POLL && canConstruct(x, y, frameType)){
                    poll[x][y] = true;
                    count++;
                }
                if(frameType == BO && canConstruct(x, y, frameType)){
                    bo[x][y] = true;
                    count++;
                }
            }else if(operation == DEL){
                if(frameType == POLL && canRemove(x, y, frameType)){
                    poll[x][y] = false;
                    count--;
                }
                if(frameType == BO && canRemove(x, y, frameType)){
                    bo[x][y] = false;
                    count--;
                }
            }
        }
        int[][] answer = new int[count][3];
        int index=0;
        for(int i = 1; i<=n+1; i++){
            for(int j=1; j<=n+1; j++){
                if(poll[i][j]) answer[index++] = new int[]{i-1, j-1, POLL};
                if(bo[i][j]) answer[index++] = new int[]{i-1, j-1, BO};
            }
        }
        return answer;
    }
    
    public boolean canConstruct(int x, int y, int frameType){
        if(frameType == POLL){
            return y == 1 || poll[x][y-1] || bo[x][y] || bo[x -1][y];
        }else{
            return poll[x][y-1]|| poll[x+1][y-1] || (bo[x+1][y] && bo[x-1][y]);
        }
    }
    
    public boolean canRemove(int x, int y, int frameType){
        boolean result = true; 
        if (frameType == POLL){
            poll[x][y] = false;
        }else{
            bo[x][y] = false;
        }
        for(int i=1; i <= n + 1; i++){
            for(int j=1; j <= n + 1; j++){
                if(poll[i][j] && !canConstruct(i, j, POLL)){
                    result = false;
                    break;
                }
                if(bo[i][j] && !canConstruct(i, j, BO)){
                    result = false;
                    break;
                }
            }
        }
        if (frameType == POLL){
            poll[x][y] = true;
        }else{
            bo[x][y] = true;
        }
        return result;
    }
}