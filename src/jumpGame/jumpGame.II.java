/* this passed the test but it may run into the problem when everything is in distance 1,
   then the stack will take too much space
*/
public class Solution {
    class Node {
        public int value;
        public int index;
        public Node(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }
    public int jump(int[] A) {
        LinkedList<Node> stack = new LinkedList<Node>();
        int l = A.length;
        if (l < 2) return 0;
        for (int i=l-2; i>=0; i--) {
            if (A[i] >= l-1-i) {
                stack.clear();
                stack.add(new Node(1, i));
                continue;
            }
            if (stack.size() == 0) continue;
            if (A[i] < stack.getFirst().index - i) {
                continue;
            }
            
            Node current = stack.poll();
            while (stack.size() > 0 && A[i] >= stack.getFirst().index - i) {
                current = stack.poll();
            }
            stack.push(current);
            stack.push(new Node(current.value+1, i));
        }
        if (stack.size() > 0 && stack.getFirst().index == 0) {
            return stack.getFirst().value;
        }
        return -1;
    }
}
