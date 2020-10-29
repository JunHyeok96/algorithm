class Solution {
    public String solution(int n) {
        String answer = "";
        for(int i=0; i<n; i++) answer+= Character.toString("수박".charAt(i%2));
        return answer;
    }
}