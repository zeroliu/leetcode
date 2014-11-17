public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        if (numRows == 0) { return results; }
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        results.add(list);
        for (int row=1; row < numRows; row++) {
            ArrayList<Integer> prev = (ArrayList<Integer>)results.get(row-1);
            List<Integer> current = new ArrayList<Integer>();
            for (int i=0; i<row+1; i++) {
                if (i == 0 || i == row) {
                    current.add(1);
                } else {
                    current.add(prev.get(i-1) + prev.get(i));
                }
            }
            results.add(current);
        }
        return results;
    }
}
