import java.math.BigInteger;

class Solution {
    public long solution(int w, int h) {
        long gcd = BigInteger.valueOf(w).gcd(BigInteger.valueOf(h)).intValue();
        long empty = (w/gcd)+ (h/gcd) -1;
        return  (long)w*h - empty*gcd;
    }
}