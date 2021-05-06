import java.util.*;

class Solution {
    int[] xDiff = new int[]{0, 0, 1, -1};
    int[] yDiff = new int[]{1, -1, 0, 0}; 
    public int solution(int[][] maps) {
        int answer = 0;
        return bfs(maps, new Point(maps.length - 1, maps[0].length - 1));
    }
    
    public int bfs(int[][] maps, Point dst){
        Queue<Point> needToGo = new LinkedList<>();
        boolean[][] visited = new boolean[maps.length][maps[0].length];
        int[][] dist = new int[maps.length][maps[0].length];
        dist[0][0] = 1;
        needToGo.offer(new Point(0, 0));
        while(!needToGo.isEmpty()){
            Point node = needToGo.poll();
            if(!isVisited(visited, node) && isValid(maps, node)){
                visited[node.x][node.y] = true;
                for(int i=0; i < 4; i++){
                    if(node.x + xDiff[i] >= 0 && node.x + xDiff[i] < maps.length 
                       && node.y + yDiff[i] >= 0 && node.y + yDiff[i] < maps[0].length){
                        if(node.x + xDiff[i] == dst.x && node.y + yDiff[i] == dst.y){
                            return dist[node.x][node.y] + 1;
                        }
                        else if(isValid(maps, new Point(node.x + xDiff[i], + node.y + yDiff[i]))){
                            if(dist[node.x + xDiff[i]][node.y + yDiff[i]] !=0){
                                dist[node.x + xDiff[i]][node.y + yDiff[i]] = Math.min(dist[node.x][node.y] + 1, dist[node.x + xDiff[i]][node.y + yDiff[i]]);
                            }else{
                                dist[node.x + xDiff[i]][node.y + yDiff[i]] = dist[node.x][node.y] + 1;
                            }
                            needToGo.offer(new Point(node.x + xDiff[i], + node.y + yDiff[i]));
                        }
                    }
                }
            }
        }
        return -1;
    }
    
    public boolean isVisited(boolean[][] visited, Point node){
        return visited[node.x][node.y];
    }
    
    public boolean isValid(int[][] maps, Point node){
        return maps[node.x][node.y] == 1;
    }
    
}

class Point{
    int x;
    int y;
    
    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }
    
}