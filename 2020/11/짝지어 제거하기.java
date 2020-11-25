import java.util.*;

class Solution
{
    public int solution(String s)
    {
        int answer = 0;
        Stack<Character> stack = new Stack<>();
        char[] arr = s.toCharArray();
        for(char ch: arr){
            if(!stack.isEmpty() && stack.peek() == ch){
                stack.pop();
            }else{
                stack.push(ch);
            }
        }
        return stack.isEmpty() ? 1 : 0;
    }
}