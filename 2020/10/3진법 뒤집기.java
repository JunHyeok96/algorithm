class Solution {
    public int solution(int n) {
        String third = Integer.toString(n, 3);
        StringBuffer strbuf = new StringBuffer(third);
        String reverse = strbuf.reverse().toString();
        int exp = 0;
        int answer = 0;
         for(int i=reverse.length()-1; i >= 0; i--){
            answer += Integer.parseInt(reverse.substring(i,i+1)) * Math.pow(3, exp++);
        }
        return answer;
    }
}