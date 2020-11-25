class Solution {
    public int[] solution(String s) {
        int remove_zero = 0;
        int count = 0;
        while(!s.equals("1")){
            int before_length = s.length();
            s = s.replace("0", "");
            remove_zero += before_length - s.length();
            s = Integer.toString(s.length(), 2);
            count++;
        }
        return new int[]{count, remove_zero};
    }
}