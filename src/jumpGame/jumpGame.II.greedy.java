/* A greedy solution, O(1) space */
public class Solution {
    public int jump(int[] A) {
        if (A.length < 2) {
            return 0;
        }
        int start = 0;
        int end = A[0];
        int step = 0;
        while (start < end) {
            step++;
            if (end >= A.length-1) return step;
            int dist = 0;
            for (int i=start; i<=end; i++) {
                dist = Math.max(i + A[i], dist);
            }
            start = end;
            end = dist;
        }
        return -1;
    }
}
