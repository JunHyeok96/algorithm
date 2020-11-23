import java.util.*;

class Solution {
    public int[] solution(String s) {
        Set<Integer> set = new HashSet<>();
        s = s.substring(1, s.length()-1);
        s = s.replace("},{", "}/{" );
        String[] arr = s.split("/");
        Arrays.sort(arr, (s1, s2) -> s1.length() - s2.length());
        int[] answer = new int[arr.length];
        for(int i=0; i<arr.length ; i++){
            String tuple = arr[i].substring(1, arr[i].length()-1);
            String[] item = tuple.split(",");
            for(String num : item){
                if(set.add(Integer.parseInt(num))){
                    answer[i] =Integer.parseInt(num);
                    break;
                }
            }
        }
        return answer;
    }
}