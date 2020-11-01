class Solution {
    public boolean solution(String[] phone_book) {
        for(int i=0; i<phone_book.length; i++){
            for(int j=0; j<phone_book.length; j++){
                if(i!=j && phone_book[i].length() < phone_book[j].length()){
                        if(phone_book[j].substring(0, phone_book[i].length()).equals(phone_book[i])){
                            return  false;
                        }
                    }
                }
            }
        return true;
    }
}