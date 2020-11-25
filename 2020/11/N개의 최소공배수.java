class Solution {
    public int solution(int[] arr) {
        for(int i=0; i < arr.length -1; i++){
            int result = arr[i] * arr[i+1];
            int min = Math.min(arr[i], arr[i+1]);
            int div = 1;
            for(int j=2; j <= min ; j++){
                if(arr[i]%j == 0 && arr[i+1]%j == 0){
                    div=j;
                }
            }
            arr[i+1] = result/div;
        }
        return arr[arr.length-1];
    }
}