public class LRUCache {
    
    class ListNode {
        int key;
        int value;
        ListNode next = null;
        ListNode parent = null;
        public ListNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    
    ListNode head = null;
    ListNode tail = null;
    int count = 0;
    int capacity = 0;
    HashMap<Integer, ListNode> map;
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<Integer, ListNode>();
    }
    
    public int get(int key) {
        if (!this.map.containsKey(key)) {
            return -1;
        }
        ListNode node = this.map.get(key);
        moveForward(node);
        return this.map.get(key).value;
    }
    
    void moveForward(ListNode node) {
        if (node != this.head) {
            ListNode next = node.next;
            ListNode parent = node.parent;
            node.next = this.head;
            this.head.parent = node;
            node.parent = null;
            this.head = node;
            parent.next = next;
            if (next != null) {
                next.parent = parent;
            }
            if (this.tail == node) {
                this.tail = parent;
            }
        }
    }
    
    public void set(int key, int value) {
        ListNode node = new ListNode(key, value);
        if (this.map.containsKey(key)) {
            moveForward(this.map.get(key));
            this.map.put(key, node);
            if (this.count == 1) {
                this.head = node;
                this.tail = node;
            } else {
                node.next = this.head.next;
                this.head.next.parent = node;
                this.head = node;
            }
            return;
        }
        
        this.map.put(key, node);

        if (this.count < capacity) {
            if (this.count == 0) {
                this.tail = node;
            } else {
                this.head.parent = node;
                node.next = this.head;
            }
            this.head = node;
            count ++;
        } else {
            this.map.remove(this.tail.key);
            if (this.capacity == 1) {
                this.head = node;
                this.tail = node;
            } else {
                ListNode beforeTail = this.tail.parent;
                beforeTail.next = null;
                this.tail = beforeTail;
                node.next = this.head;
                this.head.parent = node;
                this.head = node;
            }
        }
    }
}
