class Solution {
    public String solution(String s) {
        String answer = "";
        int word_idx = 0;
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == ' '){
                word_idx = 0;
                answer += ' ';
                continue;
            }else{
                if( word_idx%2==0 ){
                    answer += Character.toUpperCase(s.charAt(i));
                }else{
                    answer += Character.toLowerCase(s.charAt(i));
                }
                word_idx++;
            }
        }
    return answer;
    }
}