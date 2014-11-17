public class Solution {
    public int numTrees(int n) {
        HashMap<Integer, Integer> cache = new HashMap<Integer, Integer>();
        cache.put(0, 1);
        cache.put(1, 1);
        cache.put(2, 2);
        if (n <= 2) {
            return cache.get(n);
        }
        for (int i=3; i<=n; i++) {
            int sum = 0;
            for (int j=1; j<=i; j++) {
                sum += cache.get(j-1) * cache.get(i-j);
            }
            cache.put(i, sum);
        }
        return cache.get(n);
    }
}
