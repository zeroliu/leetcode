public class Solution {
    public List<String[]> solveNQueens(int n) {
        List<String[]> results = new LinkedList<String[]>();
        int[] solution = new int[n];
        if (n == 0) { return results; }
        
        solveNQueensHelper(n, 0, solution, results);
        return results;
    }
    
    void solveNQueensHelper(int n, int currentRow, int[] solution, List<String[]> results) {
        if (currentRow == n) {
            String[] result = new String[n];
            for (int i=0; i<n; i++) {
                result[i] = makeLine(n, solution[i]);
            }
            results.add(result);
            return;
        }
        
        for (int i=0; i<n; i++) {
            solution[currentRow] = i;
            if (isValid(currentRow, i, solution)) {
                solveNQueensHelper(n, currentRow+1, solution, results);
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
    
    public String makeLine(int n, int selected) {
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<n; i++) {
            if (i != selected) {
                sb.append(".");
            } else {
                sb.append("Q");
            }
        }
        return sb.toString();
    }
}
