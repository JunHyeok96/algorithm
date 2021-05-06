import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        int length = s.length();
        for(int i=0; i < length; i++){
            answer = isCorrect(s) ? answer + 1 : answer;
            s = rotate(s);
        }
        return answer;
    }
    
    public String rotate(String s){
        return s.substring(1, s.length()) + s.charAt(0);
    }
    
    public boolean isCorrect(String s){
        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray()){
            if(c == '{' || c == '[' || c == '('){
                stack.push(c);
            }else if(c == '}'){
                if(stack.isEmpty() || stack.peek() != '{'){
                    return false;
                }
                stack.pop();
            }else if(c == ']'){
                if(stack.isEmpty() || stack.peek() != '['){
                    return false;
                }
                stack.pop();
            }else if(c == ')'){
                if(stack.isEmpty() || stack.peek() != '('){
                    return false;
                }
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
}