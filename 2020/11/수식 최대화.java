import java.util.*;

class Solution {
    char[][] arr = {{'*', '-', '+'},
                    {'*', '+', '-'},
                    {'-', '*', '+'},
                    {'-', '+', '*'},
                    {'+', '-', '*'},
                    {'+', '*', '-'}};
    long max = 0;
    public long solution(String expression) {
        ArrayList<Long> q = new ArrayList<Long>();
        ArrayList<Character> cal = new ArrayList<Character>();
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<expression.length(); i++){
            char c = expression.charAt(i);
            if(c == '-' || c == '+' || c == '*'){
                cal.add(c);
                String num = sb.toString();
                sb.delete(0, num.length());
                q.add(Long.parseLong(num));
            }else{
                sb.append(c);
            }
        }
        q.add(Long.parseLong(sb.toString()));

        for(char[] list : arr){
            ArrayList<Long> new_q = new ArrayList<Long>(q);
            ArrayList<Character> new_cal = new ArrayList<Character>(cal);
            for(int i=0; i<3; i++){
                while(new_cal.contains(list[i])){
                    int idx = new_cal.indexOf(list[i]);
                    if(new_cal.get(idx)==list[i]){
                        if(list[i] == '*'){
                            new_q.set(idx, new_q.get(idx) * new_q.get(idx+1));
                        }else if(list[i] == '-'){
                            new_q.set(idx, new_q.get(idx) - new_q.get(idx+1));
                        }else if(list[i] == '+'){
                            new_q.set(idx, new_q.get(idx) + new_q.get(idx+1));
                        }
                        new_q.remove(idx+1);                
                        new_cal.remove(idx);
                    }
                }
            }
            max = Math.max(Math.abs(new_q.get(0)), max);
        }
        return max;
    }
}