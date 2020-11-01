class Solution {
    public boolean solution(int x) {
        int sum = 0;
        String []number = Integer.toString(x).split("");
        for(String num : number) sum += Integer.parseInt(num);
        return x % sum == 0;
    }
}