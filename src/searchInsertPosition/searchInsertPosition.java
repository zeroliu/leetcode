public class Solution {
    public int searchInsert(int[] A, int target) {
        int start = 0;
        int end = A.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (target > A[mid]) {
                start = mid + 1;
            } else if (target < A[mid]) {
                end = mid - 1;
            } else {
                return mid;
            }
        }
        return start;
    }
}
