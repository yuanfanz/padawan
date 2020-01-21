class LRUCache {

    class Node {
        private Node prev;
        private Node next;
        private int key;
        private int value;
        
        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    
    private int capacity;
    private Map<Integer, Node> map;
    private Node head;
    private Node tail;
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if (!map.containsKey(key)) return -1;
        
        Node curt = map.get(key);
        curt.next.prev = curt.prev;
        curt.prev.next = curt.next;
        
        curt = moveLast(curt);
        
        return curt.value;
    }
    
    public void put(int key, int value) {
        if (get(key) != -1) {
            map.get(key).value = value;
            return;
        }
        if (map.size() == capacity) {
            map.remove(head.next.key);
            head.next.next.prev = head;
            head.next = head.next.next;
        }
        Node newNode = new Node(key, value);
        newNode = moveLast(newNode);
        map.put(key, newNode);
    }
    
    private Node moveLast(Node curt) {
        curt.prev = tail.prev;
        tail.prev.next = curt;
        curt.next = tail;
        tail.prev = curt;
        return curt;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
