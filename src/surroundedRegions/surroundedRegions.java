public class Solution {
    public void solve(char[][] board) {
        int height = board.length;
        if (height == 0) return;
        int width = board[0].length;
        if (width == 0) return;
        boolean[] death = new boolean[height * width];
        boolean[] visited = new boolean[height * width];
        
        for (int y=0; y<height; y++) {
            for (int x=0; x<width; x++) {
                int key = y*width + x;
                if (visited[key]) continue;
                if (board[y][x] == 'X') continue;
                LinkedList<Integer> cache = new LinkedList<Integer>();
                LinkedList<Integer> stack = new LinkedList<Integer>();
                stack.add(key);
                visited[key] = true;
                while (stack.size() > 0) {
                    int ck = stack.poll();
                    int px = ck % width;
                    int py = ck / width;
                    cache.add(ck);
                    for (int dy=-1; dy<=1; dy++) {
                        for (int dx=-1; dx<=1; dx++) {
                            if (dy*dx != 0 || dy==dx) continue;
                            int newX = dx+px;
                            int newY = dy+py;
                            int newK = newY * width + newX;
                            if (newX < 0 || newX >= width || newY < 0 || newY >= height || death[newK]) {
                                //out of bound
                                for (int k: cache) {
                                    death[k] = true;
                                }
                                cache = new LinkedList<Integer>();
                            } else if (!visited[newK] && board[newY][newX] == 'O') {
                                visited[newK] = true;
                                stack.add(newK);
                            }
                        }
                    }
                }
                if (cache.size() > 0) {
                    for (int k: cache) {
                        int px = k % width;
                        int py = k / width;
                        board[py][px] = 'X';
                    }
                }
            }
        }
    }
}
