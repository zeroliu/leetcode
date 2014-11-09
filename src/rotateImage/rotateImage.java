public class Solution {
    public void rotate(int[][] matrix) {
        rotate(matrix, 0);    
    }
    
    void rotate(int[][] matrix, int layer) {
        int ml = matrix.length;
        if (layer >= ml / 2) {
            return;
        }
        for (int i=layer; i<ml-layer-1; i++) {
            swap(matrix, i, layer);
        }
        rotate(matrix, layer + 1);
    }
    
    void swap(int[][] matrix, int x, int y) {
        int tmp = matrix[y][x];
        int ml = matrix.length;
        for (int i=0; i<3; i++) {
            int yn = ml - 1 - x;
            int xn = y;
            matrix[y][x] = matrix[yn][xn];
            x = xn;
            y = yn;
        }
        matrix[y][x] = tmp;
    }
}
