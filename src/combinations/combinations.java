public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        if (k == 0) { return results; }
        List<Integer> l = new ArrayList<Integer>();
        combine(n, k, 1, results, l);
        return results;
    }
    
    void combine(int n, int k, int start, List<List<Integer>> results, List<Integer> l) {
        if (k == 0) {
            results.add(l);
            return;
        }
        
        for (int i=start; i<=n-k+1; i++) {
            List<Integer> a = new ArrayList<Integer>(l);
            a.add(i);
            combine(n, k-1, i+1, results, a);
        }
    }
}
