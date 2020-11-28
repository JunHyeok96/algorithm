import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        List<String> list1 = makeList(str1);
        List<String> list2 = makeList(str2);
        int answer = calJacard(list1, list2);
        return answer;
    }
    
    public int calJacard(List<String> list1, List<String> list2){
        if(list1.isEmpty() && list2.isEmpty()){
            return 1 * 65536;
        }
        float min = 0;
        float max = list2.size();
        for(String s1 : list1){
            if(list2.contains(s1)){
                min +=1;
                list2.remove(s1);
            }else{
                max +=1;
            }
        }
        return (int)(min/max *65536);
        
    }
    
    public boolean isValid(char c){
        if(c < 'a' || c > 'z'){
            return false;
        }else{
            return true;
        }
    }
    
    public List<String> makeList(String str){
        str = str.toLowerCase();
        List<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for(int i=1; i<str.length(); i++){
            if(!isValid(str.charAt(i-1)) || !isValid(str.charAt(i))){
                continue;
            }else{
                sb.append(String.valueOf(str.charAt(i-1)));
                sb.append(String.valueOf(str.charAt(i)));
                list.add(sb.toString());
                sb.delete(0, 2);
            }
        }
        return list;
    }
}