import java.util.*;

class Solution {
    boolean[] visited;
    Set<Integer> primeSet = new HashSet<>();
    
    public int solution(String numbers) {
        visited = new boolean[numbers.length()];
        for(int i=0; i < numbers.length(); i++) search("", numbers);
        return primeSet.size();
    }
    
    public void search(String s, String numbers){
        if(!s.isEmpty()){
            int number = Integer.parseInt(s);
            if(isPrime(number))primeSet.add(number);
        }
        for(int i=0; i < numbers.length(); i++){
            if(!visited[i]){
                visited[i] = true;
                search(s + numbers.charAt(i), numbers);
                visited[i] = false;
            }
        }
    } 

    public boolean isPrime(int number){
        if(number < 2) return false;
        for(int i=2; i <= number/2; i++) if(number%i == 0) return false;
        return true;
    }
}