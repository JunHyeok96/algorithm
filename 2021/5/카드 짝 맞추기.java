import java.util.*;
 
class Solution {
    Set<Integer> cardType = new HashSet<>();
    List<int[]> cardPermutation = new ArrayList<>();
    int[] xDiff = new int[]{0, 0, 1, -1};
    int[] yDiff = new int[]{1, -1, 0, 0};
   
    public int solution(int[][] board, int r, int c) {
        int answer = Integer.MAX_VALUE;
        saveCardType(board);
        for(int[] cards : cardPermutation){
            boolean[][] v = new boolean[4][4];
            int[][] tempBoard = deepcopy(board);
            int[] position = new int[]{r, c};
            int count = 0;
            for(int card : cards){
                count += bfs(position, tempBoard, card);
                count += bfs(position, tempBoard, card);
            }
            answer = Math.min(answer, count);
        }
        return answer + cardType.size() * 2;
    }
    
    public int bfs(int[] start, int[][] board, int dst){
        Queue<int[]> needToGo = new LinkedList<>();
        boolean[][] visited = new boolean[4][4];
        int[][] depth = new int[4][4];
        needToGo.offer(start);
        while(!needToGo.isEmpty()){
            int[] node = needToGo.poll();
            if(board[node[0]][node[1]] == dst){
                board[node[0]][node[1]] = 0;
                start[0] = node[0];
                start[1] = node[1];
                return depth[node[0]][node[1]];
            }
            if(!visited[node[0]][node[1]]){
                visited[node[0]][node[1]] = true;
                for(int i=0; i < 4; i++){
                    int[] togo = getPosition(node[0] + xDiff[i], node[1] + yDiff[i]);
                    if(visited[togo[0]][togo[1]]){
                        continue;
                    }
                    depth[togo[0]][togo[1]] = depth[togo[0]][togo[1]] == 0 ? depth[node[0]][node[1]] + 1 : depth[togo[0]][togo[1]];
                    needToGo.offer(togo);
                }
                int i = 1;
                while(node[0] + i < 3 && board[node[0] + i][node[1]] == 0){
                    i++;
                }
                int[] togo = getPosition(node[0] + i, node[1]);
                if(!visited[togo[0]][togo[1]]){
                    depth[togo[0]][togo[1]] = depth[togo[0]][togo[1]] == 0 ? depth[node[0]][node[1]] + 1 : depth[togo[0]][togo[1]];
                    needToGo.offer(togo);
                }

                i = 1;
                while(node[1] + i < 3 && board[node[0]][node[1] + i] == 0){
                    i++;
                }
                togo = getPosition(node[0], node[1] + i);
                if(!visited[togo[0]][togo[1]]){
                    depth[togo[0]][togo[1]] = depth[togo[0]][togo[1]] == 0 ? depth[node[0]][node[1]] + 1 : depth[togo[0]][togo[1]];
                    needToGo.offer(togo);
                }
                
                
                i = 1;
                while(node[0] - i >= 0 && board[node[0] - i][node[1]] == 0){
                    i++;
                }
                togo = getPosition(node[0] - i, node[1]);
                if(!visited[togo[0]][togo[1]]){
                    depth[togo[0]][togo[1]] = depth[togo[0]][togo[1]] == 0 ? depth[node[0]][node[1]] + 1 : depth[togo[0]][togo[1]];
                    needToGo.offer(togo);
                }
                
                i = 1;
                while(node[1] - i >= 0 && board[node[0]][node[1] - i] == 0){
                    i++;
                }
                togo = getPosition(node[0], node[1] - i);
                if(!visited[togo[0]][togo[1]]){
                    depth[togo[0]][togo[1]] = depth[togo[0]][togo[1]] == 0 ? depth[node[0]][node[1]] + 1 : depth[togo[0]][togo[1]];
                    needToGo.offer(togo);
                }
            }
        }
        return 0;
    }

    public void saveCardType(int[][] board){
        for(int[] rows : board){
            for(int col : rows){
                if(col != 0){
                    cardType.add(col);
                }
            }
        }
        permutation(new LinkedList<Integer>(), new boolean[10]);
    }

    public int[] getPosition(int x, int y){
        x = Math.max(x, 0);
        x = Math.min(x, 3);
        y = Math.max(y, 0);
        y = Math.min(y, 3);
        return new int[]{x, y};
    }
    
    public int[][] deepcopy(int[][] board){
        int[][] tempBoard = new int[4][4];
        for(int i=0; i<4; i++){
            tempBoard[i] = board[i].clone();
        }
        return tempBoard;
    }
    
    public void permutation(LinkedList<Integer> list ,boolean[] visited){
        if(list.size() == cardType.size()){
            int[] arr = new int[list.size()];
            for(int i=0; i < arr.length; i++){
                arr[i] = list.get(i);
            }
            cardPermutation.add(arr);
            return; 
        }
        for(int type :  cardType){
            if(!visited[type]){
                visited[type] = true;
                list.add(type);
                permutation(list, visited);
                list.removeLast();
                visited[type] = false;
            }
        }
    }
}