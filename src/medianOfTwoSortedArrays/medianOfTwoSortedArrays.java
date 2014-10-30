package medianOfTwoSortedArrays;

/**
 * Created by zeroliu on 10/23/14.
 */

/* There are two sorted arrays A and B of size m and n respectively. Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
*/

public class medianOfTwoSortedArrays {
    public double findMedianSortedArrays(int A[], int B[]) {
        return findMedianSortedArrays(A, 0, A.length-1, B, 0, B.length-1);
    }

    int binarySearch(int[] A, int low, int high, int key) {
        while (low <= high) {
            int mid = (low + high) / 2;
            if (key == A[mid]) {
                return mid;
            } else if (key > A[mid]) {
                low = low + 1;
            } else {
                high = high - 1;
            }
        }
        return low;
    }

    double findMedianSortedArrays(int A[], int lowA, int highA, int B[], int lowB, int highB) {
        if (highA - lowA < highB - lowB) {
            return findMedianSortedArrays(B, lowB, highB, A, lowA, highA);
        }

        int mid = (lowA + highA) / 2;
        int num = binarySearch(B, lowB, highB, A[mid]);
        int trueMid = (A.length + B.length) / 2;
        int sum = mid + num;
        if (sum == trueMid) {
            //deal with odd and even cases
            if ((A.length + B.length) % 2 == 1) {
                return A[mid];
            }

            int previous = 0;
            if (mid > 0 && num > 0) {
                return (A[mid] + Math.max(A[mid-1],B[num-1])) / 2.0;
            }
            if (mid > 0) {
                return (A[mid] + A[mid-1]) / 2.0;
            }
            if (num > 0) {
                return (A[mid] + B[num-1]) / 2.0;
            }
            return (A[mid] + B[num]) / 2.0;

        } else if (sum < trueMid) {
            return findMedianSortedArrays(A, mid+1, highA, B, num, highB);
        } else {
            return findMedianSortedArrays(A, lowA, mid - 1, B, lowB, num - 1);
        }
    }
}
