import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int people = 0;
        int idx = 0;
        char buf = words[0].charAt(0);
        Set<String> set = new HashSet<>();
        for(String word : words){
            if(word.length() == 1 || buf != word.charAt(0) || !set.add(word)){
                people = set.size()%n + 1;
                idx = set.size()/n + 1;
                return new int[]{people, idx};
            }
            buf = word.charAt(word.length()-1);
        }
        return new int[]{0, 0};
    }
}