public class Solution {
    public boolean isValidSudoku(char[][] board) {
        //check horizontal
        for (int y=0; y<board.length; y++) {
            HashSet<Character> set = new HashSet();
            for (int x=0; x<board.length; x++) {
                char c = board[y][x];
                if (c != '.') {
                    if (set.contains(c)) {
                        return false;
                    }
                    set.add(c);
                }
            }
        }
        
        //check vertical
        for (int x=0; x<board.length; x++) {
            HashSet<Character> set = new HashSet();
            for (int y=0; y<board.length; y++) {
                char c = board[y][x];
                if (c != '.') {
                    if (set.contains(c)) {
                        return false;
                    }
                    set.add(c);
                }
            }
        }
        
        //check squared
        for (int a=0; a<3; a++) {
            for (int b=0; b<3; b++) {
                HashSet<Character> set = new HashSet();
                for (int x=a*3; x<a*3+3; x++) {
                    for (int y=b*3; y<b*3+3; y++) {
                        char c = board[y][x];
                        if (c != '.') {
                            if (set.contains(c)) {
                                return false;
                            }
                            set.add(c);
                        }
                    }
                }
            }
        }
        return true;
    }
}
