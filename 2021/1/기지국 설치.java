class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int position=1;
        int idx=0;
        while(position <= n){
            if(idx < stations.length && stations[idx] - w <= position){
                position = stations[idx++] + w + 1;
            }else{
                answer++;
                position += 2*w + 1;
            }
        }
        return answer;
    }
}