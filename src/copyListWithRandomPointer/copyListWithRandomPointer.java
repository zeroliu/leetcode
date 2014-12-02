/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) { return null; }
        
        HashMap<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
        LinkedList<RandomListNode> queue = new LinkedList<RandomListNode>();
        queue.add(head);
        RandomListNode newHead = new RandomListNode(head.label);
        map.put(head, newHead);
        while (queue.size() > 0) {
            RandomListNode node = queue.poll();
            RandomListNode newNode = map.get(node);
                
            if (node.next != null) {
                if (!map.containsKey(node.next)) {
                    RandomListNode nextNode = new RandomListNode(node.next.label);
                    map.put(node.next, nextNode);
                }
                queue.add(node.next);
                newNode.next = map.get(node.next);
            }
            if (node.random != null) {
                if (!map.containsKey(node.random)) {
                    RandomListNode randNode = new RandomListNode(node.random.label);
                    map.put(node.random, randNode);
                }
                newNode.random = map.get(node.random);
            }
        }
        return newHead;
    }
}