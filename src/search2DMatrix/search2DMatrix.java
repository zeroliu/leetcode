public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int height = matrix.length;
        if (height == 0) return false;
        int width = matrix[0].length;
        if (width == 0) return false;
        
        int start = 0;
        int end = height - 1;
        int mid = 0;
        while (start <= end) {
            mid = (start + end) / 2;
            if (target > matrix[mid][0]) {
                start = mid + 1;
            } else if (target < matrix[mid][0]) {
                end = mid - 1;
            } else {
                return true;
            }
        }
        start --;
        if (start < 0) { return false; }
        
        int row = start;
        start = 0;
        end = width - 1;
        mid = 0;
        while (start <= end) {
            mid = (start + end) / 2;
            if (target > matrix[row][mid]) {
                start = mid + 1;
            } else if (target < matrix[row][mid]) {
                end = mid - 1;
            } else {
                return true;
            }
        }
        return false;
    }
}
