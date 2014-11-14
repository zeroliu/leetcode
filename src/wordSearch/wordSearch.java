public class Solution {
    public boolean exist(char[][] board, String word) {
        if (word.length() == 0) return true;
        int height = board.length;
        if (height == 0) return false;
        int width = board[0].length;
        if (width == 0) return false;
        
        char firstC = word.charAt(0);
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                if (board[y][x] == firstC) {
                    boolean[] path = new boolean[width*height];
                    if (match(y, x, board, word, path)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    boolean match(int y, int x, char[][] board, String word, boolean[] path) {
        int height = board.length;
        int width = board[0].length;
        if (word.length() == 0) return true;
        char firstC = word.charAt(0);
        for (int dy = -1; dy <= 1; dy++) {
            for (int dx = -1; dx <= 1; dx++) {
                if (dy * dx != 0) { continue; }
                int newY = y + dy;
                int newX = x + dx;
                if (newY >= height || newX >= width || newY < 0 || newX < 0 || path[newY * width + newX]) {
                    continue;
                }
                if (board[newY][newX] == firstC) {
                    boolean[] newPath = Arrays.copyOf(path, path.length);
                    newPath[newY * width + newX] = true;
                    if (match(newY, newX, board, word.substring(1), newPath)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
