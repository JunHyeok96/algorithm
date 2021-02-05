import java.util.*;
class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int time = 1;
        int complete = 0;
        int total_weight = 0;
        int truck_idx = 0;
        Queue<Truck> queue = new LinkedList<>();
        while(complete != truck_weights.length){
            if(!queue.isEmpty() && queue.peek().start_time <= time - bridge_length){
                total_weight -= queue.poll().weight;
                complete++;
                if(complete == truck_weights.length){
                    break;
                }
            }
            if(truck_idx < truck_weights.length 
               && total_weight + truck_weights[truck_idx] <= weight){
                total_weight += truck_weights[truck_idx];
                queue.offer(new Truck(truck_weights[truck_idx], time));
                truck_idx++;
            }
            time++;
        }
        return time;
    }
}
class Truck{
    int weight;
    int start_time;
    
    public Truck(int weight, int start_time){
        this.weight = weight;
        this.start_time = start_time;
    }
}