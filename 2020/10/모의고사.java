import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

class Solution {
    public int[] solution(int[] answers) {
        int[] person1 = {1, 2, 3, 4, 5};
        int[] person2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] person3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int[] score = {0, 0, 0};
        int length = answers.length;
        for(int i=0; i<length; i++){
            if(answers[i] == person1[i%person1.length]) score[0]+=1;
            if(answers[i] == person2[i%person2.length]) score[1]+=1;
            if(answers[i] == person3[i%person3.length]) score[2]+=1;
        }
        int max =  Arrays.stream(score).max().getAsInt();
        List<Integer> answer = new ArrayList<Integer>();
        for(int i =0; i<3; i++) if(max == score[i]) answer.add(i+1);
        return answer.stream().mapToInt(i->i.intValue()).toArray();
    }
}