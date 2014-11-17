public class Solution {
    public int largestRectangleArea(int[] height) {
        LinkedList<Integer> indexStack = new LinkedList<Integer>();
        LinkedList<Integer> valStack = new LinkedList<Integer>();
        int hl = height.length;
        if (hl == 0) return 0;
        valStack.add(height[0]);
        indexStack.add(0);
        int max = 0;
        for (int i=1; i<hl; i++) {
            int prevI = i;
            while (valStack.size() > 0 && height[i] < valStack.getFirst()) {
                prevI = indexStack.poll();
                max = Math.max(max, valStack.poll() * (i-prevI));
                
            }
            
            if (valStack.size() == 0 || height[i] > valStack.getFirst()) {
                indexStack.addFirst(prevI);
                valStack.addFirst(height[i]);
            }
        }
        while (valStack.size() > 0) {
            max = Math.max(max, valStack.poll() * (hl-indexStack.poll()));
        }
        return max;
    }
}
