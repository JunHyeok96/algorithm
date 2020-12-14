class Solution
{
    public int solution(String s)
    {
        int answer = 1;
        char[] arr = s.toCharArray();
        for(int center = 1; center< arr.length - 1; center++){
            int left = center-1;
            int right = center+1;
            while(arr[left]==arr[right]){
                answer = Math.max(answer, right-left + 1);
                if(left-1 < 0 || right + 1 >= arr.length){
                    break;
                }
                left--;
                right++;
            }
        }
        for(int center = 0; center< arr.length-1; center++){
            int left = center;
            int right = center+1;
            while(arr[left]==arr[right]){
                answer = Math.max(answer, right-left + 1);
                if(left-1 < 0 || right + 1 >= arr.length){
                    break;
                }
                left--;
                right++;
            }
        }
        return answer;
    }

    public int palindrome(char[] arr, int start, int end){
        for(int i=0; i < (end-start +1)/2; i++){
            if(arr[i + start] != arr[end-i]){
                return -1;
            }
        }
        return end-start + 1;
    }

}