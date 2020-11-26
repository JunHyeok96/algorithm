import java.util.*;

class Solution {
    List<Integer> set = new ArrayList<>();
    public int solution(int[] nums) {
        int answer = 0;
        comb(nums, 0, 0, 0);
        int max = Collections.max(set);
        boolean[] primeCheck = isPrime(max);
        for(int num : set){
            answer = primeCheck[num] ? answer : answer + 1;
        }
        return answer;
    }
    public boolean[] isPrime(int max){
        boolean[] check = new boolean[max+1];
        for(int i=2; i <= max; i++){
            if(check[i] == true){
                continue;
            }else{
                for(int j=i*2; j<= max; j+=i){
                    check[j] = true;
                }
            }
        }
        return check;
    }
    
    public void comb(int[] nums, int sum, int depth, int target){
        if(target == 3){
            set.add(sum);
            return;
        }else if(depth == nums.length){
            return;
        }
        comb(nums, sum + nums[depth], depth + 1, target + 1);
        comb(nums, sum, depth + 1, target);
    }
}