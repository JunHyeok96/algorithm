import java.util.*;

class Solution {
    List<Integer> list = new ArrayList<>();
    int[] arr;
    public int solution(int N, int number) {
        int answer = 9;
        arr = new int[10];
        int num = N;
        for(int i =0; i< 9; i++){
            arr[i + 1] = num;
            num = num*10 + N;
        }
        search(N, 0, 0, number, 1);
        if(list.size() > 0) answer = Collections.min(list);
        return answer > 8 ? -1 : answer;
    }
    
    public void search(int input, int count, int result, int number, int repeat){
        if(result == number){
            list.add(count);
            return;
        }
        if(count > 8){
            return;
        }
        search(input, count+1, result + arr[repeat], number, 1);
        search(input, count+1, result * arr[repeat], number, 1);
        search(input, count+1, result / arr[repeat], number, 1);
        search(input, count+1, result - arr[repeat], number, 1);
        search(input, count+1, result, number, repeat+1);
    }
}