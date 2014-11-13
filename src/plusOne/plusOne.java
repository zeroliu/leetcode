public class Solution {
    public int[] plusOne(int[] digits) {
        int dl = digits.length;
        int[] tmpResults = new int[dl+1];
        int incrementor = 1;
        for (int i = dl-1; i>=0; i--) {
            tmpResults[i+1] = (digits[i] + incrementor) % 10;
            incrementor = (digits[i] + incrementor) / 10;
        }
        if (incrementor == 1) {
            tmpResults[0] = 1;
            return tmpResults;
        }
        int[] results = new int[dl];
        for (int i=0; i<dl; i++) {
            results[i] = tmpResults[i+1];
        }
        return results;
    }
}
