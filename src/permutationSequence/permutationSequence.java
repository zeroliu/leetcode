public class Solution {
    public String getPermutation(int n, int k) {
        if (n == 0) { return ""; }
        int bound = factorial(n-1);
        ArrayList<Integer> cache = new ArrayList<Integer>();
        for (int i=1; i<=n; i++) {
            cache.add(i);
        }
        StringBuilder sb = new StringBuilder();
        k = k-1;
        for (int i=n-1; i>=1; i--) {
            int index = k/bound;
            k = k % bound;
            sb.append(cache.get(index));
            cache.remove(index);
            bound /= i;
        }
        sb.append(cache.get(0));
        return sb.toString();
    }
    
    int factorial(int n) {
        int result = 1;
        for (int i=1; i<=n; i++) {
            result *= i;
        }
        return result;
    }
}
