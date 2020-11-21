class Solution {
    int zero=0; int one=0;
    
    public int[] solution(int[][] arr) {
        compress(arr, 0, 0, arr.length);
        return new int[]{zero, one};
    }
    
    public void compress(int[][] arr, int x_offset, int y_offset, int size){
        if(size < 1) return;
        int sum = 0;
        for(int i=x_offset; i <x_offset + size ; i++){
            for(int j=y_offset; j<y_offset + size; j++){
                sum+=arr[i][j];
            }
        }
        if(sum == 0) zero += 1;
        else if(sum == size*size) one += 1;
        else{
            int[] x = {0, 0 , 1, 1};
            int[] y = {0, 1, 0, 1};
            for(int i=0; i<4; i++){
                compress(arr, x_offset + size/2 * x[i], y_offset + size/2 * y[i], size/2);
            }
        }
    }
}