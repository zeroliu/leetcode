public class Solution {
    public int singleNumber(int[] A) {
        if (A == null || A.length == 0) { return 0; }
        int num = A[0];
        for (int i=1; i<A.length; i++) {
            num ^= A[i];
        }
        return num;
    }
}