class Solution {
    boolean solution(String s) {
        s = s.toLowerCase();
        int count = 0;
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == 'p'){
                count+=1;
            }else if(s.charAt(i)=='y'){
                count-=1;
            }
        }
        return count == 0 ? true : false;
    }
}