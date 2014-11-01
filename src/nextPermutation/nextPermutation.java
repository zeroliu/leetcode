public class Solution {
    public void nextPermutation(int[] num) {
        if (num.length <= 1) {
            return;
        }
        if (!nextPerm(num, 0)) {
            reverse(num, 0);
        }
    }
    
    boolean nextPerm(int[] num, int start) {
        if (start == num.length - 1) {
            return false;
        }
        boolean changed = nextPerm(num, start+1);
        if (changed) {
            return true;
        }
        if (num[start] >= num[start+1]) {
            return false;
        }
        
        // can treat in this digit
        int firstBigger = binarySearch(num, start+1, num[start]);
        swap(num, firstBigger, start);
        reverse(num, start+1);
        return true;
    }
    
    int binarySearch(int[] num, int start, int target) {
        int last = num.length - 1;
        while (start <= last) {
            int mid = (last + start) / 2;
            if (target < num[mid]) {
                start = mid+1;
            } else if(target >= num[mid]) {
                last = mid-1;
            }  
        }
        return last;
    } 
    
    void swap(int[] num, int a, int b) {
        int tmp = num[a];
        num[a] = num[b];
        num[b] = tmp;
    }
    
    void reverse(int[] num, int start) {
        int last = num.length-1;
        while (start < last) {
            swap(num, start, last);
            start++;
            last--;
        }
    }
}
