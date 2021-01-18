import java.util.*;

class Solution {
    int[] dx = new int[]{0, 0, -1, 1};
    int[] dy = new int[]{1, -1, 0, 0};
    
    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;
        boolean[][] check = new boolean[m][n];
        int[] answer = new int[2];
        for(int i=0; i < m; i++){
            for(int j=0; j < n; j++){
                if(picture[i][j] == 0 || check[i][j] == true){
                    continue;
                }
                numberOfArea++;
                int count = search(picture, check, i, j);
                if(count > maxSizeOfOneArea){
                    maxSizeOfOneArea = count;
                }
            }
        }
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }
    
    public int search(int[][] picture, boolean[][] check, int x, int y){
        int count = 0;
        Queue<int[]> queue = new LinkedList();
        queue.offer(new int[]{x,y});
        while(!queue.isEmpty()){
            int[] point = queue.poll();
            if(check[point[0]][point[1]] == true){
                continue;
            }
            check[point[0]][point[1]] = true;
            count++;
            for(int i=0; i<4; i++){
                int newX = point[0] + dx[i];
                int newY = point[1] + dy[i];
                if((newX < picture.length && newX >= 0) 
                   && (newY >=0 && newY < picture[0].length)
                   && check[newX][newY] == false
                   && picture[newX][newY] == picture[x][y]){
                    queue.offer(new int[]{newX,newY});
                }
            }
        }
        return count; 
    }

}