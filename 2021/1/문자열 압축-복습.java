class Solution {
    public int solution(String s) {
        int length = s.length();
        int answer = length;
        for(int i = 1; i <= length/2; i++){
            String buffer = "";
            int repeat = 0;
            int size = 0;
            for(int j = 0; j < length; j += i){
                String word = s.substring(j, Math.min(j + i, length));
                if(buffer.length() == 0 || !buffer.equals(word)){
                    if(repeat == 1){
                        size += buffer.length();
                    }else if(repeat > 1){
                        size += buffer.length() + Math.log10(repeat) + 1;
                    }
                    buffer = word;
                    repeat = 1;
                }else{
                    repeat++;
                }
            }
            if(repeat == 1){
                size += buffer.length();
            }else if(repeat > 1){
                size += buffer.length() + Math.log10(repeat) + 1;
            }
            answer = Math.min(answer, size);
        }
        return answer;
    }
}