import java.util.*;
class Solution {
    Set<Set<String>> set = new HashSet<>();
    public int solution(String[] user_id, String[] banned_id) {
        int answer = 0;
        search(user_id, banned_id, new boolean[user_id.length], 0, new HashSet<String>());
        return set.size();
    }
    
    public void search(String[] user_id, String[] banned_id, boolean[] check,
                       int depth, Set<String> tmpSet){
        if(depth == banned_id.length && tmpSet.size() == banned_id.length){
            set.add(tmpSet);
            return;
        }
        for(int i=0; i<user_id.length; i++){
            if(!check[i] && isMatched(user_id[i], banned_id[depth])){
                check[i] = true;
                tmpSet.add(user_id[i]);
                search(user_id, 
                       banned_id, 
                       check, 
                       depth+1, 
                       new HashSet<String>(tmpSet));
                tmpSet.remove(user_id[i]);
                check[i] = false;
            }
        } 
        
    }
    
    public boolean isMatched(String input, String banned_id){
        if(banned_id.length() != input.length()){
            return false;
        }
        for(int i=0; i< banned_id.length(); i++){
            if(banned_id.charAt(i) == '*'){
                continue;
            }
            if(banned_id.charAt(i) != input.charAt(i)){
                return false;
            }
        }
        return true;
    }
}