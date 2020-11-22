import java.util.*;

class Solution {
    int answer = 0;
    public int solution(int n, String[] data) {
        String[] arr = {"A", "C", "F", "J", "M", "N", "R", "T"};
        boolean[] check = new boolean[8];
        make_list(arr, check, "", data);
        return answer;
    }
    
    public void make_list(String[] arr, boolean[] check, String item, String[] data ){
        if(item.length() == arr.length){
            for(String condition : data){
                int a_idx = item.indexOf(condition.charAt(0));
                int b_idx = item.indexOf(condition.charAt(2));
                char cal = condition.charAt(3);
                int diff = condition.charAt(4) - '0';
                int ab_diff = Math.abs(a_idx - b_idx) - 1;
                if(cal == '<' && ab_diff >= diff){
                    return;
                }
                if(cal == '=' && ab_diff != diff){
                    return;
                }
                if(cal == '>' && ab_diff <= diff){
                    return;
                }
            }
            answer +=1;
            return;
        }
        for(int i=0; i < arr.length; i++){
            if(check[i] ==false){
                check[i] = true;
                make_list(arr, check, item.concat(arr[i]), data);
                check[i]=false;
            }
        }
    }
    
}