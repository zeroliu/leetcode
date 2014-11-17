public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] num) {
        Arrays.sort(num);
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        results.add(new LinkedList<Integer>());
        int size = 0;
        int startIndex = 0;
        for (int i=0; i<num.length; i++) {
            startIndex = (i >= 1 && num[i] == num[i-1]) ? size : 0;
            size = results.size();
            for (int j=startIndex; j<size; j++) {
                List<Integer> res = new LinkedList<Integer>(results.get(j));
                res.add(num[i]);
                results.add(res);
            }
        }
        return results;
    }
}
