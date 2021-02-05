class Solution {
    public int solution(String name) {
        int answer = 0;
        char[] arr = new char[name.length()];
        for(int i=0; i < arr.length; i++){
            arr[i] = 'A';
        } 
        int idx=0;
        while(!new String(arr).equals(name)){
            answer += countControll(name.charAt(idx));
            arr[idx] = name.charAt(idx);
            int right = 0;
            int left = 0;
            for(int i=1; i<arr.length; i++){
                right = (idx + i)% arr.length;
                if(arr[right] != name.charAt(right)){
                    idx = right;
                    answer+=i;
                    break;
                }
                left = (idx - i + arr.length) % arr.length;
                if(arr[left] != name.charAt(left)){
                    idx = left;
                    answer+=i;
                    break;
                }
            }     
            if(right==left){
                break;
            }
        }
        return answer;
    }
    
    public int countControll(char dst){
        return Math.min(dst - 'A', Math.abs('Z' - dst + 1));
    }
}