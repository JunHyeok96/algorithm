class Solution {
    public int solution(int n) {
        int answer = 0;
        long[] arr = new long[n+1];
        arr[1] = 1L;
        arr[2] = 2L;
        for(int i=3; i <= n; i++){
            arr[i] = arr[i-1] + arr[i-2];
            arr[i]%=1000000007;
        }
        return (int)arr[n]%1000000007;
    }
}