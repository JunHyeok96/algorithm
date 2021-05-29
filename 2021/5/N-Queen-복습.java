class Solution {
    int[] col;
    int answer = 0;
    int n;
    public int solution(int n) {
        this.n = n;
        for(int i=0; i < n; i ++){
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
        for(int i=0; i < n; i++){
            col[depth] = i;
            if(canInsert(depth, col)){
                search(depth + 1);
            }
        }
    }

    public boolean canInsert(int depth, int[] col){
        for(int i=0; i < depth; i++){
            if(col[i] == col[depth]) return false;
            if(Math.abs(i - depth) == Math.abs(col[i] - col[depth])) return false;
        }
        return true;
    }
}