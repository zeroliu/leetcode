public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int height = triangle.size();
        if (height == 0) { return 0; }
        if (height == 1) { return triangle.get(0).get(0); }
        for (int i=1; i<height; i++) {
            List<Integer> prev = triangle.get(i-1);
            List<Integer> current = triangle.get(i);
            for (int j=0; j<i+1; j++) {
                if (j==0) {
                    current.set(j, prev.get(j) + current.get(j));
                } else if (j==i) {
                    current.set(j, prev.get(j-1) + current.get(j));
                } else {
                    current.set(j, Math.min(prev.get(j-1),prev.get(j)) + current.get(j));
                }
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i=0; i<height; i++) {
            int val = triangle.get(height-1).get(i);
            if (val < min) {
                min = val;
            }
        }
        return min;
    }
}
