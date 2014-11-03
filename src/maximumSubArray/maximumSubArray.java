public class Solution {
    public int maxSubArray(int[] A) {
    	int l = A.length;
    	int cache = 0;
    	int max = Integer.MIN_VALUE;
    	for (int i=0; i<l; i++) {
    		if (i == 0) {
    			cache = A[i];			
    		} else {
    			cache = Math.max(A[i] + cache, A[i]);
    		}
    		max = Math.max(cache, max);
    	}
    	return max;
    }

}
