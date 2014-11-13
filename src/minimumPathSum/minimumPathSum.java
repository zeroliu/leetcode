public class Solution {
    public int minPathSum(int[][] grid) {
        int height = grid.length;
        if (height == 0) {return 0;}
        int width = grid[0].length;
        
        int[][] cost = new int[height][];
        for (int i=0; i<height; i++) {
            cost[i] = new int[width];
            for (int j=0; j<width; j++) {
                cost[i][j] = Integer.MAX_VALUE;
            }
        }
        cost[0][0] = grid[0][0];
        
        for (int y=0; y<height; y++) {
            for (int x=0; x<width; x++) {
                if (x<width-1) {
                    int costRight = cost[y][x] + grid[y][x+1];
                    cost[y][x+1] = Math.min(cost[y][x+1], costRight);
                }
                if (y<height-1) {
                    int costDown = cost[y][x] + grid[y+1][x];
                    cost[y+1][x] = Math.min(cost[y+1][x], costDown);
                }
            }
        }
        
        return cost[height-1][width-1];
    }
}
