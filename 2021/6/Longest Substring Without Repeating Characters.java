    class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int answer = 0;
        int j = 0;
        for(int i=0; i < s.length(); i++){
            if(set.add(s.charAt(i))){
                answer = Math.max(answer, i - j + 1);
            }else{
                while(!set.add(s.charAt(i))){
                    set.remove(s.charAt(j++));
                }
            }
        }
        return answer;
    }
}