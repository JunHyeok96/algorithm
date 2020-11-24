class Solution {
    boolean solution(String s) {
        char[] arr = s.toCharArray();
        int sum=0;
        for(char c : arr){
            sum = c=='(' ? sum+1 : sum-1;
            if(sum<0) return false;
        }
        return sum==0;
    }
}
