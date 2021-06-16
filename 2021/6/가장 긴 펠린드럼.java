class Solution
{
    public int solution(String s)
    {
        int answer = 0;
        for(int i = 0; i< s.length(); i++){
            int tempAnswer = 1;
            for(int j=1; i - j >= 0 && i + j < s.length(); j++){
                if(s.charAt(i - j) != s.charAt(i + j)){
                    break;
                }
                tempAnswer += 2;
            }
            answer = Math.max(answer, tempAnswer);
            tempAnswer = 0;
            for(int j= 0; i - j >= 0 && i + j + 1 < s.length(); j++){
                if(s.charAt(i - j) != s.charAt(i + 1 + j)){
                    break;
                }
                tempAnswer += 2;
            }
            answer = Math.max(answer, tempAnswer);
        }
        return answer;
    }
}