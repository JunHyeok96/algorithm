import java.util.*;

class Solution {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int[] answer = new int[enroll.length];
        Map<String, Integer> resultMap = new HashMap<>();
        Map<String, String> connectionMap = makeConnection(enroll, referral);
        for(int i = 0; i< seller.length; i++){
            String start = seller[i];
            int price = amount[i] * 100; 
            while(!start.equals("-")){
                int newPrice = (int)(price * 0.1);
                int savePrice = price - newPrice;
                resultMap.put(start, resultMap.getOrDefault(start, 0) + savePrice);
                start = connectionMap.get(start);
                price = newPrice;
            }
        }    
        for(int i=0; i < enroll.length; i++){
            answer[i] = resultMap.getOrDefault(enroll[i], 0);
        }
        return answer;
    }
    
    public Map<String, String> makeConnection(String[] enroll, String[] referral){
        Map<String, String> map = new HashMap<>();
        for(int i=0; i<enroll.length; i++){
            map.put(enroll[i], referral[i]);
        }
        return map;
    }
}