class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int[] position = new int[truck_weights.length];
        int idx=0;
        int cur_weight=0;
        int complete = 0;
        while(complete < truck_weights.length){
            if(idx < truck_weights.length && cur_weight + truck_weights[idx] <= weight){
                position[idx]= bridge_length;
                cur_weight += truck_weights[idx++];
            }
            for(int i=complete; i < position.length; i++){
                if(position[i] > 0){
                    position[i]--;
                    if(position[i] == 0){
                        complete++;
                        cur_weight-= truck_weights[i];
                    }
                }else{
                    break;
                }
            }
            answer++;
        }
        return answer+1;
    }
}