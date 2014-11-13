public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int height = obstacleGrid.length;
        if (height == 0) return 0;
        if (obstacleGrid[0][0] == 1) return 0;
        int width = obstacleGrid[0].length;
        int[][] cache = new int[height][];
        for (int i=0; i<height; i++) {
            cache[i] = new int[width];
        }
        cache[0][0] = 1;
        for (int y=0; y<height; y++) {
            for (int x=0; x<width; x++) {
                if (x == 0 && y == 0) continue;
                if (obstacleGrid[y][x] == 1) {
                    cache[y][x] = 0;
                } else {
                    int sum = 0;
                    if (y > 0) {
                        int up = cache[y-1][x];
                        if (up > 0) {
                            sum += up;
                        }
                    }
                    if (x > 0) {
                        int left = cache[y][x-1];
                        if (left > 0) {
                            sum += left;
                        }
                    }
                    cache[y][x] = sum;
                }
            }
        }
        return cache[height-1][width-1];
    }
}
