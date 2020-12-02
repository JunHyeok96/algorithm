import java.util.*;
class Solution {
    StringBuilder sb = new StringBuilder();
    public String[] solution(String[] files) {
        String[] answer = {};
        Arrays.stream(files).map(i -> i.toLowerCase());
        Arrays.sort(files, (s1, s2) -> {
            String[] s1Arr = split(s1);
            String[] s2Arr = split(s2);
            if(s1Arr[0].compareTo(s2Arr[0]) == 0){
                return Integer.parseInt(s1Arr[1]) - Integer.parseInt(s2Arr[1]);
            }else{
                return s1Arr[0].compareTo(s2Arr[0]);
            }
        });
        return files;
    }
    
    public String[] split(String s){
        String[] arr = new String[2];
        s = s.toLowerCase();
        for(int i=0; i< s.length(); i++){
            if(s.charAt(i) >= '0' && s.charAt(i) <= '9'){
                break;
            }
            sb.append(s.charAt(i));
        }
        arr[0] = sb.toString();
        sb.setLength(0);
        for(int i=arr[0].length(); i< s.length(); i++){
            if(s.charAt(i) >= '0' && s.charAt(i) <= '9'){
                sb.append(s.charAt(i));
            }else{
                break;
            }
        }
        arr[1] = sb.toString();
        sb.setLength(0);
        return arr;
    }
}