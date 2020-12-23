class Solution {
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        int INF = Integer.MAX_VALUE;
        int[][] connected = new int[N + 1][N+1];
        int[] time = new int[N+1];
        boolean[] visited = new boolean[N+1];
        for(int[] roadArr : road){
            if(connected[roadArr[0]][roadArr[1]] == 0 ||
               connected[roadArr[0]][roadArr[1]] > roadArr[2]){
                connected[roadArr[0]][roadArr[1]] = roadArr[2];
                connected[roadArr[1]][roadArr[0]] = roadArr[2];
            }
        }
        for(int i=1; i<=N; i++){
            for(int j=1; j<=N; j++){
                connected[i][j] = connected[i][j]==0? INF : connected[i][j];
            }
            time[i] = connected[1][i];
        }
        visited[1] = true;
        for(int i=2; i<=N; i++){
            int node = getSmallNode(time, visited);
            visited[node] = true;
            for(int j=2; j<=N; j++){
                if(j == node) continue;
                if(connected[node][j] != INF &&  time[node] != INF &&
                   time[node] + connected[node][j]  < time[j]){
                    time[j] = time[node] + connected[node][j];
                }
            }
        }        
        for(int i=2; i<=N; i++){
            if(time[i] <= K) answer++;
        }
        return answer+1;
    }
    
    public int getSmallNode(int[] arr, boolean[] visited){
        int min = Integer.MAX_VALUE;
        int node = 0;
        for(int i=1; i < arr.length; i++){
            if(arr[i] < min && !visited[i]){
                min = arr[i];
                node = i;
            }
        }
        return node; 
    }
}