import java.util.*;
class Solution {
    public int solution(String s) {
        int answer = s.length();
        for(int i=1; i< s.length(); i++){
            String buf ="";           
            int count = 0;
            int comp_count = 0;
            boolean compress = false;
            for(int j = 0; j * i< s.length() + 1; j++){
                int from = i*j; int to = i*(j+1);
                if(to > s.length()) to = s.length();
                String value = s.substring(from, to);
                if(value.equals(buf)){
                    compress = true;
                    comp_count+=1;
                }else{
                    if(comp_count > 0){
                        count += Math.log10(comp_count + 1) + 1;
                    }
                    comp_count = 0;
                    buf = value;
                    count += value.length();
                }
            }
            if(compress){
                answer = count < answer ? count : answer;
            }
        }
        return answer;
    }
    
}