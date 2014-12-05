public class Solution {
    public int evalRPN(String[] tokens) {
        if (tokens == null || tokens.length == 0) {return 0;}
        int l = tokens.length;
        LinkedList<String> stack = new LinkedList<String>();
        for (int i=0; i<l; i++) {
            if (!isOperand(tokens[i])) {
                stack.addFirst(tokens[i]);
            } else {
                String operand = tokens[i];
                int num2 = Integer.parseInt(stack.poll());
                int num1 = Integer.parseInt(stack.poll());
                int res = 0;
                if (operand.equals("+")) {
                    res = num1 + num2;
                } else if (operand.equals("-")) {
                    res = num1 - num2;
                } else if (operand.equals("*")) {
                    res = num1 * num2;
                } else if (operand.equals("/")) {
                    res = num1 / num2;
                }
                stack.addFirst(Integer.toString(res));
            }
        }
        return Integer.parseInt(stack.poll());
    }
    
    boolean isOperand(String token) {
        return (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/"));
    }
}