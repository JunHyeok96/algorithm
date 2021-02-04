import java.util.*;

class Solution {
    Set<Integer> set = new HashSet<>();
    public int solution(String numbers) {
        int answer = 0;
        char[] arr = numbers.toCharArray();
        permutation("", numbers);
        for(int num : set){
            answer += isprime(num);
        }
        return answer;
    }
    
    public void permutation(String result, String number){
        if(!result.isEmpty()) set.add(Integer.parseInt(result));
        for(int i=0; i < number.length(); i++){
           permutation(result+number.charAt(i), number.substring(0, i) + number.substring(i+1, number.length()));
        }
    }
    
    public int isprime(int input){
        if(input < 2) return 0;
        for(int i=2; i <= input/2; i++){
            if(input%i==0){
                return 0;
            }
        }
        return 1;
    }   
    
}