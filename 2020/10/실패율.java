import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        HashMap<Integer, Double> fail = new HashMap<>();
        int[] answer = new int[N];
        ArrayList<Integer> stageList = new ArrayList<>(N);
        for(int i=1; i<=N; i ++){
            stageList.add(Integer.valueOf(i));
            int attempt = 0;
            int clear = 0;
            for(int stage : stages){
                if(stage >= i) attempt+=1;
                clear = stage > i ? clear + 1 : clear;
            }
            fail.put(i, attempt == 0 ? 0 : 1- (double)clear/attempt);
        }
        Collections.sort(stageList, new Comparator<Integer>() {
            @Override
            public int compare(Integer i1, Integer i2){
                if(fail.get(i1) > fail.get(i2)){
                    return -1;
                } else if(fail.get(i1) < fail.get(i2)){
                    return 1;
                } else {
                    return 0;
                }
            }
        });
        
        return stageList.stream().mapToInt(i -> i.intValue()).toArray();
    }
}