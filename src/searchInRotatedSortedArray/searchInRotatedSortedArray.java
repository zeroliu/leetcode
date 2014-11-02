public class Solution {
    public int search(int[] A, int target) {
        int rp = findRotatePoint(A);
        if (rp == 0) {
            return binarySearch(A, 0, A.length-1, target);
        }
        
        if (target < A[0]) {
            return binarySearch(A, rp, A.length-1, target);
        }
        return binarySearch(A, 0, rp-1, target);
    }
    
    int binarySearch(int[] A, int start, int end, int target) {
        int mid = 0;
        while (start <= end) {
            mid = (start + end) / 2;
            if (target < A[mid]) {
                end = mid - 1;
            } else if (target > A[mid]) {
                start = mid + 1;
            } else {
                return mid;
            }
        }
        
        return -1;
    }
    
    int findRotatePoint(int[] A) {
        int start = 0;
        int end = A.length-1;
        int mid = 0;
        while(start <= end) {
            mid = (start + end) / 2;
            if (A[mid] >= A[0]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        if (A[mid] >= A[0]) {
            if (mid == A.length-1) {
                return 0;
            }
            return mid + 1;
        }
        return mid;
    }
}
