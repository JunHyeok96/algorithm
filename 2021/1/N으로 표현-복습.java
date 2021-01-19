class Solution {
    int[] arr = new int[10];
    int answer = 9;
    int number;
    public int solution(int N, int number) {
        arr[1] = N;
        this.number = number;
        for(int i=2; i < 10; i++){
            arr[i] = arr[i-1] * 10 + N; 
        }
        search(0, 0, 1);
        return answer == 9 ? -1 : answer;
    }
    
    public void search(int result, int depth, int repeat){
        if(depth > 8){
            return;
        }
        if(number == result){
            answer = Math.min(answer, depth);
            return;
        }
        search(result + arr[repeat], depth+1, 1);
        search(result - arr[repeat], depth+1, 1);
        search(result * arr[repeat], depth+1, 1);
        search(result / arr[repeat], depth+1, 1);
        search(result, depth+1, repeat+1);
    }
}