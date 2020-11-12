import java.util.*;

class Solution {   
    List<Integer> counts = new ArrayList<>();
    public void dfs(String[] words, String begin, String target, int count, boolean[] chk){
        if(target.equals(begin)) {
            counts.add(count);
            return;
        }
        for(int i=0; i< words.length; i++){
            if(check(begin, words[i]) && chk[i] == false ){
                chk[i] = true;
                boolean[] copy_chk = chk.clone();
                dfs(words, words[i], target, count+1, copy_chk);
             }
        } 
    }
    
    public boolean check(String s1, String s2){
        if(s1.equals(s2)) return false;
        int count=0;
        for(int i=0; i<s1.length(); i++) if(s1.charAt(i)!=s2.charAt(i)) count+=1;
        return count == 1;
    }
    
    public int solution(String begin, String target, String[] words) {
        boolean []chk = new boolean[words.length]; 
        if(!Arrays.stream(words).anyMatch(target::equals)) return 0;
        for(String word : words) dfs(words, begin, target, 0, chk);
        return Collections.min(counts);
    }
}