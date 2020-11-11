import java.util.*;

class Solution {
    public int solution(String numbers) {
       int answer = 0;
        HashSet<Integer> set = new HashSet<>();
        permutation("", numbers, set);
        for(int number : set){
            answer += isPrime(number);
        }
        return answer;
    }
    public int isPrime(int number){
        if(number<2) return 0;
        for(int i=2; i< number; i++) if(number%i==0) return 0;
        return 1;
    }
                         
    public void permutation(String prefix, String number, HashSet<Integer> set){
        int length = number.length();
        if(!prefix.equals("")) set.add(Integer.parseInt(prefix));
        for(int i=0; i< length; i++){
            permutation(prefix + number.charAt(i), number.substring(0,i) + number.substring(i+1,length) , set);
        }
    }
    
}