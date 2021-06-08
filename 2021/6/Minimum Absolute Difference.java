class Solution {
    public int getMinimumDifference(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        search(root, list);
        Collections.sort(list);
        int answer = Integer.MAX_VALUE;
        for(int i=0; i < list.size() - 1 ; i++){
            answer = Math.min(answer, list.get(i + 1) - list.get(i));
        }
        return answer;
    }
    
    public void search(TreeNode node, List<Integer> list){
        if(node == null){
            return;
        }
        list.add(node.val);
        search(node.left, list);
        search(node.right, list);
    }
}