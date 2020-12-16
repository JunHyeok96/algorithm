class Solution {
    int answer;
    int n;
    int col[];
    public int solution(int n) {
        this.n=n;
        for(int i=0; i<n; i++){
            col = new int[n];
            col[0] = i;
            search(1);
        }
        return answer;
    }
    public void search(int depth){
        if(depth == n){
            answer++;
            return;
        }
        for(int i=0; i<n; i++){
            col[depth] = i;
            if(canInsert(depth)){
                search(depth+1);
            }
        }
    }
   
    public boolean canInsert(int y){
        for(int i=0; i < y; i++){
            if(col[i] == col[y]) return false;
            if(y - i == Math.abs(col[y] - col[i])) return false;
        }
        return true;
    }
}