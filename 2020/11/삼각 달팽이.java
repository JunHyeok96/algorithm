class Solution {
    public int[] solution(int n) {
        int[] answer = new int[n*(n+1)/2];
        int[][] matrix = new int[n][n];
        int x=-1; int y=0; int num=1;
        for(int i=0; i<n; i++){
            for(int j=i; j<n; j++){
                if(i%3==0){
                    x++;
                }else if(i%3==1){
                    y++;
                }else if(i%3==2){
                    x--;
                    y--;
                }
                matrix[x][y] = num++;
            }
        }
        int idx=0;
        for(int[] nums : matrix){
            for(int item : nums){
                if(item==0) break;
                answer[idx++] = item;
            }
        }
        return answer;
    }
}