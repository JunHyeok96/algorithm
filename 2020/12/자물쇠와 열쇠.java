class Solution {
    int n;
    int m;
    public int[][] turn(int[][] key) {
        int[][] ret = new int[key.length][key[0].length];
        for(int i=0; i< key.length; i++){
            for(int j=0; j< key[0].length; j++){
                ret[i][key[0].length -1 -j] =key[j][i];
            }
        }
        return ret;
    }

    public boolean chk(int[][] newLock) {
        int cnt = 0;
        for(int i=n; i< m +n; i++) {
            for(int j=n; j< m +n; j++) {
                if(newLock[i][j] == 1) cnt++;
            }
        }
        return cnt ==m*m;
    }
        
    public boolean solution(int[][] key, int[][] lock) {
        n = key.length;
        m = lock.length;
        int[][] newLock = new int[m + 2*n][m + 2*n];
        for(int i=0; i<m; i++) {
            for(int j=0; j<m; j++) {
                newLock[i+n][j+n] = lock[i][j];
            }
        }
        for(int t=0; t<4; t++) {
            key = turn(key); 
            for(int a=0; a< m + n; a++) {
                for(int b=0; b< m + n; b++) {
                    for(int i=0; i<n; i++) {
                        for(int j=0; j<n; j++) {
                            newLock[a+i][b+j] += key[i][j];
                        }
                    }
                    if(chk(newLock)) return true;
                    for(int i=0; i<n; i++) {
                        for(int j=0; j<n; j++) {
                            newLock[a+i][b+j] -= key[i][j];
                        }
                    }
                }
            }
        }
        return false;
    }
}
   