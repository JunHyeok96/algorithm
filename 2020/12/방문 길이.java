import java.util.*;
class Solution {
    public int solution(String dirs) {
        int answer = 0;
        char[] arr = dirs.toCharArray();
        int startX = 0; int startY=0;
        int endX = 0; int endY = 0;
        Set<Visit> set = new HashSet<>();
        for(char ch : arr){
            if(ch == 'U'){
                endY = startY + 1 <= 5 ? startY + 1: startY;
            }else if(ch == 'D'){
                endY = startY - 1 >= -5 ? startY - 1: startY;
            }else if(ch == 'L'){
                endX = startX - 1 >= -5 ? startX - 1: startX;
            }else if(ch == 'R'){
                endX = startX + 1 <= 5 ? startX + 1: startX;
            }
            if(startX == endX && startY==endY){
                continue;
            }
            boolean isVisited = false;
            for(Visit visit : set){
                if(visit.isCorrect(startX, startY, endX, endY)){
                    isVisited = true;
                    break;
                }
            }
            if(!isVisited){
                answer++;
                set.add(new Visit(startX, startY, endX, endY));
            }
            startX = endX;
            startY = endY;
        }
        return answer;
    }
}
class Visit{
    int startX;
    int startY;
    int endX;
    int endY;
    public Visit(int startX, int startY, int endX, int endY){
        this.startX = startX;
        this.startY = startY;
        this.endX = endX;
        this.endY = endY;
    }
    public boolean isCorrect(int startX, int startY, int endX, int endY){
        return (this.startX == startX &&
            this.startY == startY &&
            this.endX == endX &&
            this.endY == endY) ||
             (this.startX == startX &&
            this.startY == endY &&
            this.endX == endX &&
            this.endY == startY) ||
             (this.startX == endX &&
            this.startY == startY &&
            this.endX == startX &&
            this.endY == endY);
    }
}
