import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        List<Integer> prior_list = new ArrayList<>();
        List<Docs> docs_list = new ArrayList<>();
        for(int i=0; i<priorities.length; i++){
            prior_list.add(priorities[i]);
            docs_list.add(new Docs(priorities[i], i));
        } 
        Collections.sort(prior_list, Collections.reverseOrder()); 
        
        while(true){
            if(prior_list.get(0) == docs_list.get(0).value){
                answer +=1;
                if(docs_list.get(0).index == location){
                    return answer;
                }else{
                    prior_list.remove(0);
                    docs_list.remove(0);
                }
            }else{
                docs_list.add(docs_list.get(0));
                docs_list.remove(0);
            }
            
        }
    }
}

class Docs{
    int value;
    int index;
    
    public Docs(int value, int index){
        this.value=value;
        this.index=index;
    }
}