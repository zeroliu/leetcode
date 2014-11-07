public class Solution {
    public boolean canJump(int[] A) {
        int l = A.length;
        if (l < 2) return true;
        if (A[0] == 0) return false;

        for (int i=1; i<l-1; i++) {
            A[i] = Math.max(A[i-1]-1, A[i]);
            if (A[i] == 0) {
                return false;
            }
        }
        return true;
    }
}
