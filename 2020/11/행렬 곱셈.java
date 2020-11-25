class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = new int[arr1.length][arr2[0].length];
        
        for(int k=0; k<arr1.length; k++){
            for(int l=0; l<arr2[0].length; l++){
                int temp = 0;
                for(int j=0; j<arr2.length; j++){
                    temp+=arr1[k][j] * arr2[j][l];
                }
                answer[k][l] = temp;
                }
        }
        return answer;
    }
}