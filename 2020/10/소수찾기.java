class Solution {
    public int solution(int n) {
        int answer = 0;
        boolean []checked = new boolean[n+1];
        for(int i=2; i<=n; i++) checked[i] = false;
        for(int i=2; i<=n; i++){
            if(!checked[i]){
                answer++;
                for(int j = i ; j<=n; j+=i) checked[j] = true;
            }
        }
        return answer;
    }
}