class Solution {
    List<List<Integer>> answer = new ArrayList<List<Integer>>();

    public List<List<Integer>> permute(int[] nums) {
        Stack<Integer> list = new Stack<>();
        permutation(list, nums);        
        return answer;
    }
    
    public void permutation(Stack<Integer> list, int[] nums){
        if(list.size() == nums.length){
            answer.add(new ArrayList<Integer>(list));
            return;
        }
        for(int num : nums){
            if(!list.contains(num)){
                list.push(num);
                permutation(list, nums);
                list.pop();
            }
        }
    }
}