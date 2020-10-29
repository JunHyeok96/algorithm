class Solution {
    public String solution(String s, int n) {
        String answer = "";
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) >= 'a' && s.charAt(i) <= 'z'){
                answer += s.charAt(i) + n > 'z' ? (char)('a' + s.charAt(i) + n - 'z' - 1) :  (char)(s.charAt(i) + n);
            }else if(s.charAt(i) >= 'A' && s.charAt(i) <= 'Z'){
                answer += s.charAt(i) + n > 'Z' ? (char)('A' + s.charAt(i) + n - 'Z' - 1) :  (char)(s.charAt(i) + n);
            }else{
                answer += " ";
            }
        }
        return answer;
    }
}