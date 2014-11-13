public class Solution {
    public void setZeroes(int[][] matrix) {
        HashSet<Integer> row = new HashSet<Integer>();
        HashSet<Integer> column = new HashSet<Integer>();
        int height = matrix.length;
        if (height == 0) { return; }
        int width = matrix[0].length;
        for (int y=0; y<height; y++) {
            for (int x=0; x<width; x++) {
                if (matrix[y][x] == 0) {
                    row.add(y);
                    column.add(x);
                }
            }
        }
        
        for (int y=0; y<height; y++) {
            for (int x=0; x<width; x++) {
                if (row.contains(y) || column.contains(x)) {
                    matrix[y][x] = 0;
                }
            }
        }
    }
}
