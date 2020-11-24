class Solution {
    public int solution(int n) {
        String nTo2 = Integer.toString(n, 2);
        char[] arr = nTo2.toCharArray();
        int sum=0;
        for(char c : arr) sum = c == '1' ? sum+1 : sum;
        while(n <= 1000000){
            String numTo2 = Integer.toString(n+1, 2);
            char[] numArr = numTo2.toCharArray();
            int numSum = 0;
            for(char c : numArr) numSum = c == '1' ? numSum + 1 : numSum;
            if(numSum == sum){
                return n+1;
            }else{
                n++;
            }
        }
        return n;
    }
}