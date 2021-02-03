import java.util.*;
class Solution {
    public String solution(String number, int k) {
        String answer = "";
        char[] arr = number.toCharArray();
        char[] result = new char[arr.length - k];
        Stack<Character> stack = new Stack<>();
        for(char ch : arr){
            while(!stack.isEmpty() && stack.peek() < ch && k > 0){
                stack.pop();
                k--;
            }
            stack.push(ch);
        }
        for(int i=0; i<result.length; i++){
            result[i] = stack.get(i);
        }
        return new String(result);
    }
}