class Solution {
    public int[] solution(int n, int m) {
        int max_value =1;
        int nmMin = n <= m ? n : m;
        for(int i=1; i<=nmMin; i++) max_value = (n%i==0 && m%i==0) ?  i: max_value;
        int min_value = m*n / max_value;
        return new int[]{max_value, min_value};
    }
}