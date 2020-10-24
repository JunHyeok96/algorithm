import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        List<Integer> lost_person =  Arrays.stream(lost).boxed().collect(Collectors.toList());
        List<Integer> lost_person_temp = Arrays.stream(lost).boxed().collect(Collectors.toList());
        List<Integer> reserve_person = Arrays.stream(reserve).boxed().collect(Collectors.toList());
        for(int lost_number : lost_person_temp){
            if(reserve_person.contains(lost_number)){
                lost_person.remove((Integer)(lost_number));
                reserve_person.remove((Integer)(lost_number));
            }
        }
        int reserved = 0;
        for(int lost_number : lost_person){
            for(int i=0; i< reserve_person.size(); i++){
                if(Math.abs(lost_number-reserve_person.get(i))<=1){
                    reserve_person.remove(i);
                    reserved+=1;
                    break;
                }
            }
        }
        return n + reserved - lost_person.size();
    }
}