public class Solution {
    public int[][] generateMatrix(int n) {
        if (n <= 0) {return new int[0][0];}
        int[][] results = new int[n][];
        for (int i=0; i<n; i++) {
            results[i] = new int[n];
        }
        int total = n * n;
        int count = 1;
        int dx = 1;
        int dy = 0;
        int xmax = n-1;
        int xmin = 0;
        int ymax = n-1;
        int ymin = 0;
        int cx = 0;
        int cy = 0;
        while (count <= total) {
            if (dx == 1 && dy == 0) {
                if (cx >= xmax) {
                    dx = 0;
                    dy = 1;
                    ymin ++;
                }
            } else if (dx == 0 && dy == 1) {
                if (cy >= ymax) {
                    dx = -1;
                    dy = 0;
                    xmax --;
                }
            } else if (dx == -1 && dy == 0) {
                if (cx <= xmin) {
                    dx = 0;
                    dy = -1;
                    ymax --;
                }
            } else {
                if (cy <= ymin) {
                    dx = 1;
                    dy = 0;
                    xmin ++;
                }
            }
            results[cy][cx] = count;
            count ++;
            cx += dx;
            cy += dy;
        }
        return results;
    }
}
