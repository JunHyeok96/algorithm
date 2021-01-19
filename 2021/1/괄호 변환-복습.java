class Solution {
    public String solution(String p) {
        if(isCorrected(p)) return p;
        String answer = "";
        answer = processing(p);
        return answer;
    }
    
    public String processing(String p){
        if(p.length() == 0) return p;
        String u = "";
        String v = "";
        int right=0;
        int left=0;
        for(char c : p.toCharArray()){
            u+=c;
            if(c == '(') left++;
            else if(c == ')') right++;
            if(left == right){
                v = p.substring(u.length(), p.length());
                break;
            }
        }
        if(isCorrected(u)){
            return u + processing(v);
        }else{
            String temp = "(" +processing(v) + ")";
            u = u.substring(1, u.length()-1);
            u = u.replace(")", "-");
            u = u.replace("(", ")");
            u= u.replace("-", "(");
            return temp + u;
        }
    }
    
    public boolean isCorrected(String input){
        int left = 0;
        for(char c : input.toCharArray()){
            if(c == '('){
                left++;
            }else if(c == ')'){
                left--;
            }
            if(left < 0){
                return false;
            }
        }
        return true;
    }
}