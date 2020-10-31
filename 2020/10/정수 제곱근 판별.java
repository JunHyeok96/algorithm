class Solution {
    public long solution(long n) {
        double sqrt =  Math.sqrt(n);
        if( sqrt - (int)sqrt != 0){
            return -1;
        }else{
            return (long)((sqrt + 1) * (sqrt+1));
        }
    }
}