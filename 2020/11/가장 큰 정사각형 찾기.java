class Solution
{
    int max_size = 0;
    public int solution(int [][]board)
    {
        int [][] arr = new int[board.length+1][board[0].length+1];
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                if(board[i][j] == 1){
                    int min = Math.min(arr[i][j+1], arr[i+1][j]);
                    min = Math.min(min, arr[i][j]);
                    arr[i+1][j+1] = min + 1;
                    max_size = (int)Math.max(max_size, arr[i+1][j+1]);
                }
            }
        }
        return max_size * max_size;
    }
}