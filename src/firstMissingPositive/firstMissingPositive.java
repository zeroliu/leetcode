public class Solution {
    public int firstMissingPositive(int[] A) {
    	if (A == null || A.length == 0) return 1;
    
    	int l = A.length;
    	for (int i=0; i<l; i++) {
    		int index = A[i] - 1;
    		if (index < 0 || index > l-1 || A[i] == index) {
    			continue;
    		}
    		if (i != index) {
				swap(A, i, index);
				if (A[i] != A[index]) {
				    i--;
				}
    		}
    	}
    	for (int i=0; i<l; i++) {
    		if (A[i] != i+1) {
    			return i+1;
    		}
    	}
    	return l+1;
    }
    
    void swap(int[] A, int a, int b) {
    	int tmp = A[a];
    	A[a] = A[b];
    	A[b] = tmp;
    }
}
