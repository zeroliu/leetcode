public class Solution {
    public List<List<Integer>> subsets(int[] S) {
        int sl = S.length;
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        List<Integer> empty = new LinkedList<Integer>();
        results.add(empty);
        if (sl == 0) {
            return results;
        }
        Arrays.sort(S);
        for (int i=0; i<sl; i++) {
            int rl = results.size();
            for (int j=0; j<rl; j++) {
                LinkedList<Integer> list = new LinkedList<Integer>(results.get(j));
                list.add(S[i]);
                results.add(list);
            }
        }
        return results;
    }
}
