public class Solution {
    
    int count = 0;
    public int totalNQueens(int n) {
        count = 0;
        int[] solution = new int[n];
        if (n == 0) { return 0; }
        
        solveNQueensHelper(n, 0, solution);
        return count;
    }
    
    void solveNQueensHelper(int n, int currentRow, int[] solution) {
        if (currentRow == n) {
            count++;
            return;
        }
        
        for (int i=0; i<n; i++) {
            solution[currentRow] = i;
            if (isValid(currentRow, i, solution)) {
                solveNQueensHelper(n, currentRow+1, solution);
            }
        }
    }
    
    boolean isValid(int currentRow, int currentColumn, int[] solution) {
        for (int i=0; i<currentRow; i++) {
            if (solution[i] == currentColumn || Math.abs(solution[i] - currentColumn) == currentRow - i) {
                return false;
            }
        }
        return true;
    }
}
