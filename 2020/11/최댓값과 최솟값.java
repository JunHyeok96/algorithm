class Solution {
    public String solution(String s) {
        String[] arr = s.split(" ");
        int min = Integer.parseInt(arr[0]);
        int max = min;
        for(String num : arr){
            min = Math.min(min, Integer.parseInt(num));
            max = Math.max(max, Integer.parseInt(num));
        }
        String answer = min + " " + max;
        return answer;
    }
}