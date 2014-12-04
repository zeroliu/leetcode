public class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> result = new ArrayList<Integer>();
        if (n == 0) {
            result.add(0);
            return result;
        }
        int d = 1<<(n-1);
        result = grayCode(n-1);
        int size = result.size();
        for (int i=size-1; i>=0; i--) {
            result.add(result.get(i) + d);
        }
        
        return result;
    }
}