import java.math.*;

class Solution {
  public boolean splitString(String s) {
    for(int i=0; i < s.length() - 1; i++){
        BigInteger  cur = new BigInteger(s.substring(0, i + 1));
        if(isValid(s, i + 1, cur)){
            return true;
        }
    }
    return false;
  }
    
    private boolean isValid(final String s, int start, BigInteger prev) {
        if(start == s.length()){
            return true;
        }
        for(int i=start; i < s.length(); i++){
            BigInteger cur = new BigInteger(s.substring(start, i + 1));
            if(prev.compareTo(cur) == -1){
                return false;
            }
            if(prev.compareTo(cur.add(new BigInteger("1"))) == 0 && isValid(s, i + 1, cur)){
                return true;
            }
        }
        return false;
  }
}