public class Solution {
    public int maximalRectangle(char[][] matrix) {
        int row = matrix.length;
        if (row == 0) return 0;
        int col = matrix[0].length;
        if (col == 0) return 0;
        int max = 0;
        int[][] heights = new int[row][];
        for (int i=0; i<row; i++) {
            heights[i] = new int[col];
        }
        for (int y=0; y<row; y++) {
            for (int x=0; x<col; x++) {
                if (matrix[y][x] == '1') {
                    heights[y][x] = (y == 0) ? 1 : heights[y-1][x] + 1;
                }
            }
            int area = largestRectangle(heights[y]);
            if (area > max) {
                max = area;
            }
        }
        return max;
    }
    
    int largestRectangle(int[] heights) {
        LinkedList<Integer> stack = new LinkedList<Integer>();
        int max = 0;
        for (int i=0; i<heights.length;) {
            if (stack.size() == 0 || heights[stack.getFirst()] <= heights[i]) {
                stack.addFirst(i);
                i++;
            } else {
                int topIndex = stack.poll();
                int area = heights[topIndex] * (stack.size()==0? i : i-stack.getFirst()-1);
                if (area > max) {
                    max = area;
                }
            }
        }
        while (stack.size() > 0) {
            int topIndex = stack.poll();
            int area = heights[topIndex] * (stack.size()==0? heights.length : heights.length-stack.getFirst()-1);
            if (area > max) {
                max = area;
            }
        }
        
        return max;
    }
}
