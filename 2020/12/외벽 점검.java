import java.util.*;

class Solution {
    int answer = Integer.MAX_VALUE;
    boolean[] check;
    List<Integer> circle = new LinkedList<>();
    int weakCount = 0;
    public int solution(int n, int[] weak, int[] dist) {
        this.weakCount = weak.length;
        this.check = new boolean[dist.length];
        for(int point : weak){
            circle.add(point);
        }
        for(int point : weak){
            circle.add(point + n);
        }
        for(int i=1; i <= dist.length; i++){
            permutation(new LinkedList<Integer>(), dist, i);
            if(answer < Integer.MAX_VALUE){
                return answer;
            }
        }
        return -1;
    }
    
    public void permutation(LinkedList<Integer> list, int[] dist, int depth){
        if(depth == 0){
            check(list);
            return;
        }
        for(int i=0; i < dist.length; i++){
            if(!check[i]){
                check[i]=true;
                list.add(dist[i]);
                permutation(list, dist, depth-1);
                list.removeLast();
                check[i]=false;
            }
        }
    }
    
    public void check(List<Integer> friends){
        for(int i=0; i < weakCount; i++){
            int idx=0;
            int start = circle.get(i);
            boolean isChecked = true;
            for(int j = i; j < i + weakCount; j++){
                if(friends.get(idx) < circle.get(j) - start){
                    start = circle.get(j);
                    idx++;
                    if(idx == friends.size()){
                        isChecked = false;
                        break;
                    }
                }
            }
            if(isChecked){
               answer = Math.min(answer, idx + 1);
            }
        }
    }
}