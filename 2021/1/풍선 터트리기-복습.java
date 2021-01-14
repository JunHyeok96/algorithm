class Solution {
    public int solution(int[] a) {
        int answer = 2;
        int start = a[0];
        int end = a[a.length-1];
        for(int i = 1; i < a.length-1; i++){
            if(start > a[i]){
                answer++;
                start = a[i]; //최소 값
            }
            if(end > a[a.length-1 - i]){
                answer++;
                end = a[a.length-1 -i]; //최소 값 
            }
        }
        return start <= end ? answer -1 : answer;
    }
}