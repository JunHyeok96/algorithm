import java.util.HashMap;
import java.util.List;
import java.util.Arrays;

class Solution {
    public String solution(int[] numbers, String hand) {
        String answer = "";
        String rCurrentPosition = "*";
        String lCurrentPosition = "#";
        HashMap<String, List<Integer>> map = new HashMap<>();
        map.put("*", Arrays.asList(3,0));
        map.put("0", Arrays.asList(3,1));
        map.put("#", Arrays.asList(3,2));
        for(int i =1; i<=9; i++){
            map.put(Integer.toString(i), Arrays.asList((i-1)/3, (i-1)%3));
        }
        for(int num : numbers){
            String stringNum = Integer.toString(num);
            if(num == 1 || num == 4 || num == 7){
                answer += "L"; 
                lCurrentPosition = stringNum;
            }else if(num == 3 || num == 6 || num == 9){
                answer += "R"; 
                rCurrentPosition = stringNum;
            }else{
                double rDist = dist(rCurrentPosition , stringNum, map);
                double lDist = dist(lCurrentPosition , stringNum, map);      
                if(rDist>lDist){
                    answer += "L";
                    lCurrentPosition = stringNum;
                }else if(rDist<lDist){
                    answer += "R";
                    rCurrentPosition = stringNum;
                }else if(rDist == lDist) {
                    if(hand.equals("right")){
                        answer += "R";
                        rCurrentPosition = stringNum;
                    }else{
                        answer += "L";
                        lCurrentPosition = stringNum;
                    }
                } 
            }
        }
        return answer;
    }                                   
     public double dist(String a, String b, HashMap<String, List<Integer>> map){
        int x_diff = map.get(a).get(0) - map.get(b).get(0);
        int y_diff = map.get(a).get(1) - map.get(b).get(1);
        return  Math.abs(x_diff) + Math.abs(y_diff);
     }
}