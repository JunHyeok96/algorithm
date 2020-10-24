class Solution {
    public String solution(int a, int b) {
        int []dayOfMonth = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        String []week = {"SUN","MON","TUE","WED","THU","FRI","SAT"};
        int day=0;
        for(int i=0; i<a-1; i++){
            day+= dayOfMonth[i];
        }
        day+=  b;
        return week[(day + 4)%7];
    }
}