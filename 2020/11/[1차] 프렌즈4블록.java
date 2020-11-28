import java.util.*;

class Solution {
    boolean[][] check;
    char[][] board;
    int answer = 0;
    public int solution(int m, int n, String[] board) {
        check = new boolean[m][n];
        this.board = new char[m][n];
        int idx = 0;
        for(String s : board){
            this.board[idx++] = s.toCharArray();
        }
        gameStart(m, n);
        return answer;
    }
    
    public void gameStart(int m, int n){
        int[] down = new int[m];
        int count = 0;
        for(int i=0; i< m - 1; i++){
            for(int j=0; j< n - 1; j++){
                if(isSquare(i, j)){
                    count +=1;
                }
            }
        }
        if(count == 0){
            return;
        }
        pop(m, n);
        gameStart(m, n);
    }
    
    public void pop(int m, int n){
        answer = 0;
        for(int i=0; i< m; i++){
            for(int j=0; j< n; j++){
                if(check[i][j] && board[i][j] != '0'){
                    board[i][j] = '0';
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0; i< n; i++){
            for(int j=0; j< m; j++){
                if(board[j][i] != '0'){
                    sb.append(board[j][i]);
                }
            }
            char[] arr = sb.toString().toCharArray();
            sb.delete(0, arr.length);
            int idx=0;
            for(int j=0; j< m; j++){
                if(j >= m - arr.length){
                    board[j][i] = arr[idx++];
                    check[j][i] = false;
                }else{
                    board[j][i] = '0';
                    check[j][i] = true;
                    answer+=1;
                }
            }
        }
    }

    public boolean isSquare(int x, int y){
        if(board[x][y] == '0'){
            return false;
        }
        char buf = board[x][y];
        int[] xDiff = {0 ,0 ,1, 1};
        int[] yDiff = {0, 1, 0, 1};
        for(int i=0; i<4; i++){
            if(buf != board[x + xDiff[i]][y + yDiff[i]]){
                return false;
            }
        }
        for(int i=0; i<4; i++){
           check[x + xDiff[i]][y + yDiff[i]] = true;
        }
        return true;
    }
}