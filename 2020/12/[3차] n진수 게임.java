class Solution {
    public String solution(int n, int t, int m, int p) {
        StringBuilder sb = new StringBuilder();
        String answer = "";
        for(int i=0; sb.length() <=  t * m; i++){
            String num = Integer.toString(i, n);
            sb.append(num);
        }
        answer = sb.toString();
        sb.setLength(0);
        int idx =0;
        while(t > 0){
            sb.append(answer.charAt((p -1) + m*idx));
            idx++;
            t--;
        }
        return sb.toString().toUpperCase();
    }
}