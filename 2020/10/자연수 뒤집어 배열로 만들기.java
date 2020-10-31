class Solution {
    public int[] solution(long n) {
        String number = Long.toString(n);
        int[] answer = new int[number.length()];
        for(int i=0; i<number.length(); i++){
            answer[i] = Integer.parseInt(""+number.charAt(number.length() - i -1));
        }
        return answer;
    }
}