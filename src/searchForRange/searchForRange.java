public class Solution {
    public int[] searchRange(int[] A, int target) {
        int index = binarySearch(A, target, 0, A.length-1);
        if (index == -1) {
            return new int[]{-1, -1};
        }
        int start = index;
        int end = index;
        
        int tmp = start;
        while (tmp >= 0) {
            start = tmp;
            tmp = binarySearch(A, target, 0, start-1);
            
        }
        
        tmp = end;
        while (tmp >= 0) {
            end = tmp;
            tmp = binarySearch(A, target, end+1, A.length - 1);
        }
        return new int[]{start, end};
    }
    
    int binarySearch(int[] A, int target, int start, int end) {
        while (start <= end) {
            int mid = (start + end) / 2;
            if (target > A[mid]) {
                start = mid + 1;
            } else if (target < A[mid]){
                end = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
