import java.util.*;

class Solution {
    public int[] nextLargerNodes(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while(head != null){
            list.add(head.val);
            head = head.next;
        }
        int[] arr = new int[list.size()];
        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<arr.length; i++){
            while(!stack.isEmpty() && list.get(stack.peek()) < list.get(i)){
                arr[stack.pop()] = list.get(i);
            }
            stack.push(i);
        }
        return arr;
    }
}