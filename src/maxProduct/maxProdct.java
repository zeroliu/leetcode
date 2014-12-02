public class Solution {
    public int maxProduct(int[] A) {
        if (A == null || A.length == 0) { return 0; }
        int prevMax = A[0];
        int prevMin = A[0];
        int max = A[0];
        for (int i=1; i<A.length; i++) {
            int v1 = A[i];
            int v2 = prevMax * A[i];
            int v3 = prevMin * A[i];
            
            prevMin = Math.min(v1, Math.min(v2,v3));
            prevMax = Math.max(v1, Math.max(v2,v3));
            if (prevMax > max) { max = prevMax; }
        }
        return max;
    }
}