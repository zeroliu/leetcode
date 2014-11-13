public class Solution {
    public void sortColors(int[] A) {
        int[] lasts = new int[] {-1, -1, -1};
        int al = A.length;
        for (int i=0; i<al; i++) {
            if (A[i] == 2) {
                if (lasts[2] == -1) {
                    lasts[2] = i;
                }
                continue;
            }
            if (A[i] == 1) {
                int index1 = i;
                if (lasts[2] != -1) {
                    A[lasts[2]] = 1;
                    A[i] = 2;
                    index1 = lasts[2];
                    lasts[2] += 1;
                }
                if (lasts[1] == -1) {
                    lasts[1] = index1;
                }
                continue;
            }
            if (A[i] == 0) {
                int index0 = i;
                if (lasts[2] != -1) {
                    A[lasts[2]] = 0;
                    A[index0] = 2;
                    index0 = lasts[2];
                    lasts[2] += 1;
                }
                if (lasts[1] != -1) {
                    A[lasts[1]] = 0;
                    A[index0] = 1;
                    index0 = lasts[1];
                    lasts[1] += 1;
                }
                if (lasts[0] == -1) {
                    lasts[0] = index0;
                }
            }
        }
    }
}
