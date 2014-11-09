public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> results = new LinkedList<Integer>();
        if (matrix.length < 1) return results;
        int xmin = 0, xmax = matrix[0].length-1, ymin = 0, ymax = matrix.length-1;
        int dx = 1, dy = 0;
        int cx = 0, cy = 0;
        while(xmin <= xmax && ymin <= ymax) {
            if (dx == 1) {
                for (int i=xmin; i<=xmax; i++) {
                    cx=i;
                    results.add(matrix[cy][cx]);
                }
                ymin++;
                dx = 0;
                dy = 1;
            } else if (dx == -1) {
                for (int i=xmax; i>=xmin; i--) {
                    cx = i;
                    results.add(matrix[cy][cx]);
                }
                ymax--;
                dx = 0;
                dy = -1;
            } else if (dy == 1) {
                for (int i=ymin; i<=ymax; i++) {
                    cy=i;
                    results.add(matrix[cy][cx]);
                }
                xmax--;
                dx = -1;
                dy = 0;
            } else if (dy == -1) {
                for (int i=ymax; i>=ymin; i--) {
                    cy=i;
                    results.add(matrix[cy][cx]);
                }
                xmin++;
                dx = 1;
                dy = 0;
            }
        }
        return results;
    }
}

