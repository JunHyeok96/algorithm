class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        for(String phone1 : phone_book){
            int count = 0;
            for(String phone2 : phone_book){
                if(phone1.startsWith(phone2)) count++;
            }
            if(count > 1) return false;
        }
        return answer;
    }
}