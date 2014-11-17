/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) return null;
        UndirectedGraphNode newHead = new UndirectedGraphNode(node.label);
        HashMap<Integer, UndirectedGraphNode> cache = new HashMap<Integer, UndirectedGraphNode>();
        cache.put(node.label, newHead);
        LinkedList<UndirectedGraphNode> stack = new LinkedList<UndirectedGraphNode>();
        stack.add(node);
        while (stack.size() > 0) {
            UndirectedGraphNode n = stack.poll();
            UndirectedGraphNode newNode = cache.get(n.label);
             
            for (UndirectedGraphNode pn: n.neighbors) {
                if (cache.containsKey(pn.label)) {
                    newNode.neighbors.add(cache.get(pn.label));
                } else {
                    UndirectedGraphNode newPn = new UndirectedGraphNode(pn.label);
                    newNode.neighbors.add(newPn);
                    cache.put(pn.label, newPn);
                    stack.add(pn);
                }
            }
        }
        return newHead;
    }
}
