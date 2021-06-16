class Solution {
    public int[] createTargetArray(int[] nums, int[] index) {
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<nums.length; i++){
            list.add(index[i], nums[i]);
        }
        int[] answer = new int[index.length];
        for(int i=0; i < answer.length; i++){
            answer[i] = list.get(i);
        }
        return answer;
    }
}