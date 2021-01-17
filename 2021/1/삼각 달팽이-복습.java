class Solution {
    public int[] solution(int n) {
        int[] answer = new int[n*(n+1)/2];
        int[][] arr = new int[n][n];
        int num = 1;
        int x=0;
        int y=-1;
        while(n > 0){
            y++;
            for(int i=0; i < n; i++){
                arr[y++][x] = num++;
            }
            y--;
            n--;
            x++;
            for(int i=0; i < n; i++){
                arr[y][x++]= num++;
            }
            x--;
            n--;
            for(int i=0; i < n; i++){
                arr[--y][--x]= num++;
            }
            n--;
        }
        int idx = 0;
        for(int[] row : arr){
            for(int element : row){
                if(element !=0){
                    answer[idx++] = element;
                }
            }
        }
        return answer;
    }
}