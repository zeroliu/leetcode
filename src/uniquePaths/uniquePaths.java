public class Solution {
    public int uniquePaths(int m, int n) {
        int[][] cache = new int[m][];
        for (int i=0; i<m; i++) {
            cache[i] = new int[n];
        }
        
        for (int x=0; x<m; x++) {
            for (int y=0; y<n; y++) {
                if (x==0 || y==0) {
                    cache[x][y] = 1;
                } else {
                    cache[x][y] = cache[x-1][y] + cache[x][y-1];
                }
            }
        }
        return cache[m-1][n-1];
    }
}
