public class Solution {
    public int longestValidParentheses(String s) {
        int max = 0;
        int lastError = -1;
        int slength = s.length();
        LinkedList<Integer> stack = new LinkedList<Integer>();
        for (int i=0; i<slength; i++) {
            if (s.charAt(i) == '(') {
                stack.addFirst(i);
            } else if (s.charAt(i) == ')') {
                if (stack.size() == 0) {
                    lastError = i;
                } else {
                    stack.pop();
                    int l = 0;
                    if (stack.size() == 0) {
                        l = i - lastError;
                    } else {
                        l = i - stack.getFirst();
                    }
                    if (l > max) {
                        max = l;
                    }
                }
            }
        }
        return max;
    }
}
