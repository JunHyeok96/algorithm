import java.util.*;
class Solution {
    int[] diffX = new int[]{0, 0, 1, -1};
    int[] diffY = new int[]{1, -1, 0, 0};
    boolean[][] check;
    int[][] board;
    int answer = Integer.MAX_VALUE;
    public int solution(int[][] board) {
        this.board = board; 
        this.check = new boolean[board.length][board.length];
        search();
        return answer;
    }
    public void search(){
        Queue<Road> queue = new LinkedList<>();
        queue.offer(new Road(0, 0, 0, -1));
        while(!queue.isEmpty()){
            Road road = queue.poll();
            if(road.x == check.length-1 && road.y == check.length-1){
                answer = Math.min(answer, road.cost);
                continue;
            }
            for(int i=0; i<4; i++){
                int newX = road.x + diffX[i];
                int newY = road.y + diffY[i];
                if(newX >= check.length || newX < 0 ||
                   newY >= check.length || newY < 0 ||
                   board[newX][newY] == 1
                  ){
                    continue;
                }
                int cost = road.cost;
                if(road.direction == -1 || road.direction == i){
                    cost += 100;
                }else{
                    cost += 600;
                }
                if(board[newX][newY] == 0){
                    board[newX][newY] = cost;
                    queue.offer(new Road(newX, newY, cost, i));
                }else if(board[newX][newY] >= cost){
                    board[newX][newY] = cost;
                    queue.offer(new Road(newX, newY, cost, i));
                }
            } 
        }
    }
}
class Road{
    int x;
    int y;
    int cost;
    int direction;
    public Road(int x, int y, int cost, int direction){
        this.x = x;
        this.y = y;
        this.cost = cost;
        this.direction = direction;
    }
}