import java.util.*;

class Solution {
    String answer = "";
    public String solution(String p) {
        return cal(p);
    }
    
    public String cal(String p){
        int p_length = p.length();
        if(p_length==0) return "";
        if(isCorrect(p)) return p;
        String u = "";
        String v = "";
        for(int i=2; i<=p.length(); i+=2){
            String temp = p.substring(0, i);
            if(isBalance(temp)){
                u = temp;
                v = p.substring(i, p_length);
                break;
            }
        }
        if(isCorrect(u)){
            return u + answer + cal(v);
        }else{
            String temp ="(" + cal(v) +")";
            String result = u.substring(1, u.length()-1);
            result = result.replace("(", "|");
            result = result.replace(")", "(");
            result = result.replace("|", ")");
            temp+=result;
            return temp + answer;
        }
    }
        
    public boolean isBalance(String u){
        char[] arr = u.toCharArray();
        int count=0;
        for(char c : arr){
            if(c=='(') count+=1;
            if(c==')') count-=1;
        }
        return count==0;
    }
    
    public boolean isCorrect(String p){
        char[] arr = p.toCharArray();
        int count=0;
        for(char c : arr){
            if(c=='(') count+=1;
            if(c==')') count-=1;
            if(count < 0) return false;
        }
        return count==0;
    }
}