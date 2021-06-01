class Solution {
    public int solution(int sticker[]) {
        if(sticker.length == 1) return sticker[0];
        int[] dp = new int[sticker.length];
        int[] dp2 = new int[sticker.length];
        dp[0] = sticker[0];
        dp[1] = sticker[0];
        dp2[0] = 0;
        dp2[1] = sticker[1];
        for(int i=2; i < sticker.length - 1; i++){
            dp[i] = Math.max(dp[i-2] + sticker[i], dp[i -1]);
        }
        for(int i=2; i < sticker.length; i++){
            dp2[i] = Math.max(dp2[i-2] + sticker[i], dp2[i -1]);
        }
        int dpMax = Math.max(dp[sticker.length -1], dp[sticker.length -2]);
        int dp2Max = Math.max(dp2[sticker.length -1], dp2[sticker.length -2]);
        return Math.max(dpMax, dp2Max);
    }
}