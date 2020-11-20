import java.util.*;

class Solution {
    int []dx = {0, 0, 1, -1};
    int []dy = {1, -1, 0, 0};
    Queue<Node> queue = new LinkedList<>();
    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;
        boolean[][] check = new boolean[m][n];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(picture[i][j]>0 && check[i][j]==false){
                    int size = bfs(picture, check, i, j, 1);
                    numberOfArea++;
                    if(maxSizeOfOneArea < size){
                        maxSizeOfOneArea=size;
                    } 
                }
            }
        }
        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }
    
    public int bfs(int[][] picture, boolean[][] check, int x, int y, int size){
        check[x][y]= true;
        queue.offer(new Node(x, y));
        while(!queue.isEmpty()){
            Node node = queue.poll();
            for(int i=0; i<4; i++){
               int nx = node.x + dx[i];
               int ny = node.y + dy[i];
               if(nx>=0 && ny >=0 && nx <picture.length && ny<picture[0].length){
                   if(picture[nx][ny] == picture[x][y] && check[nx][ny]==false){
                       check[nx][ny] = true;
                       queue.offer(new Node(nx, ny));
                       size++;
                   }
               }
            }
        }
        return size;
    }
}

class Node{
    int x;
    int y;
    public Node(int x, int y){
        this.x= x;
        this.y= y;
    }
}