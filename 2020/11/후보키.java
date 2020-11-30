import java.util.*;

class Solution {
    List<Integer> cKeys = new ArrayList<>();
    List<List<Integer>> cKeysList = new ArrayList(); 
    List<List<Integer>> permutationList = new ArrayList<>();
    public int solution(String[][] relation) {
        int answer = 0;
        Set<String> set = new HashSet<>();
        for(int i=0; i < relation[0].length; i++){
            cKeys.add(i);
            for(int j=0; j< relation.length; j++){
                if(!set.add(relation[j][i])){
                    cKeys.remove((Integer)i);
                    break;
                }
            }
            set.clear();
        }
        int columnSize = relation[0].length;
        permutation(new ArrayList<Integer>(), columnSize, columnSize - 1);
        Collections.sort(permutationList, (i1, i2)-> i1.size() - i2.size());
        for(List<Integer> list : permutationList){
            if(!isMin(list)){
                continue;
            }
            Set<String> tempSet = new HashSet<>();
            boolean isCkey = true;
            for(int i=0; i<relation.length; i ++){
                String s = "";
                for(int idx : list){
                    s = s.concat(relation[i][idx]);
                }
                if(!tempSet.add(s)){
                    isCkey = false;
                    break;
                }
            }
            if(isCkey){
                answer += 1;
                cKeysList.add(list);
            }
        }
        
        return answer + cKeys.size();
    }

    public boolean isMin(List<Integer> list){
        for(List<Integer> clist : cKeysList){
            boolean flag = false;
            for(int num : clist){
                if(!list.contains(num)){
                    flag = true;
                    break;
                }
            }
            if(flag == false){
                return false;
            }
        }
        return true;
    }
    
    public void permutation(List<Integer> list, int size, int depth){
        if(depth < 0){
            if(list.size() > 0){
                permutationList.add(list);
            }
            return;
        }
        List<Integer> newList = new ArrayList<>(list);
        newList.add(depth);
        if(!cKeys.contains(depth)){
           permutation(newList, size, depth-1);
           permutation(list, size, depth-1);
        }else{
           permutation(list, size, depth-1);
        }

    }

}