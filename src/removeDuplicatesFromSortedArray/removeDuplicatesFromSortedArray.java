public class Solution {
    public int removeDuplicates(int[] A) {
        int size = A.length;
        if (size < 2) {
            return size;
        }
        int pointer = 0;
        int buffer = A[0];
        for (int i=1; i<size; i++) {
            if (A[i] != buffer) {
                pointer ++;
                swapValue(A, i, pointer);
                buffer = A[pointer];
            }
        }
        return pointer+1;
    }
    
    void swapValue(int[] A, int a, int b) {
        int tmp = A[a];
        A[a] = A[b];
        A[b] = tmp;
    }
}
