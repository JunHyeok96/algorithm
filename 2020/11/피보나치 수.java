class Solution {
    public int solution(int n) {
        int answer = 0;
        int first = 0;
        int two = 1;
        for(int i = 2; i<= n; i++){
            answer = first + two;
            answer %=1234567;
            first = two;
            two = answer;
        }
        return answer;
    }
    
}