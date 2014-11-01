public class Solution {
    public int removeElement(int[] A, int elem) {
        if (A.length < 1) {
            return A.length;
        }
        int p = A.length - 1;
        int s = 0;
        while (s <= p) {
            if (A[s] == elem) {
                swapValue(A, s, p);
                p--;
            } else {
                s++;
            }
        }
        return p+1;
    }
    
    void swapValue(int[] A, int a, int b) {
        int tmp = A[a];
        A[a] = A[b];
        A[b] = tmp;
    }
}
