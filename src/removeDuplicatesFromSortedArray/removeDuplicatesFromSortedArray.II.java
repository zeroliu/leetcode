public class Solution {
    public int removeDuplicates(int[] A) {
        int al = A.length;
        if (al <= 2) { return al; }
        int count = 1;
        int buffer = A[0];
        int pointer = 0;
        boolean canMove = false;
        for (int i=1; i<al; i++) {
            canMove = true;
            if (A[i] == buffer) {
                count++;
                if (count > 2) {
                    canMove = false;
                }
            } else {
                count = 1;
                buffer = A[i];
            }
            if (canMove) {
                pointer++;
                int tmp = A[pointer];
                A[pointer] = A[i];
                A[i] = tmp;
            }
        }
        return pointer+1;
    }
}
