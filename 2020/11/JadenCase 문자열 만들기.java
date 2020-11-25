class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder(s.length());
        String[] arr = s.toLowerCase().split("");
        boolean state = true;
        for(String ch : arr){
            sb.append(state == true ? ch.toUpperCase() : ch);
            state = ch.equals(" ") ? true : false;
        }
        return sb.toString(); 
    }
}