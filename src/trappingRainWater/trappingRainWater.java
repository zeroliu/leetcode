public class Solution {
    class Node {
        int value;
        int index;
        public Node(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }
    public int trap(int[] A) {
        if (A == null || A.length <= 1) {
            return 0;
        }
        int al = A.length;
        int area = 0;
        LinkedList<Node> stack = new LinkedList<Node>();
        for (int i=0; i<al; i++) {
            Node node = new Node(A[i], i);
            area += evaluateStack(stack, node);
        }
        return area;
    }
    
    int evaluateStack(LinkedList<Node> stack, Node node) {
        if (stack.size() == 0) {
            stack.addFirst(node);
            return 0;
        }
        int area = 0;
        Node head = stack.getFirst();
        Node previous = null;
        
        while (stack.size() > 0 && node.value >= head.value) {
            head = stack.poll();
            if (stack.size() > 0) {
                previous = stack.getFirst();
                area += (node.index - previous.index - 1) * (Math.min(previous.value, node.value) - head.value);
                head = previous;
            }
        }
        stack.addFirst(node);
        return area;
    }
}
