class Node {
    int key;
    int val;
    Node prev;
    Node next;

    Node(int key, int val) {
        this.key = key;
        this.val = val;
        prev = null;
        next = null;
    }
}

class LRUCache {
    int size;
    int capacity;
    Node head;
    Node tail;
    Map<Integer, Node> map;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
        map = new HashMap<>();
        size = 0;
    }
    
    public int get(int key) {
        Node node = map.get(key);
        if(node == null) return -1;
        remove(node);
        addToLast(node);
        return node.val;

    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)) {
            Node node = new Node(key, value);
            remove(map.get(key));
            addToLast(node);
            map.put(key, node);
            return;
        }
        if(size >= capacity) {
            Node removeNode = head.next;
            remove(removeNode);
            map.remove(removeNode.key);
            size--;
        }
        Node node = new Node(key, value);
        addToLast(node);
        map.put(key, node);
        size++;
    }

    public void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;

    }
    public void addToLast(Node node) {
        Node prev = tail.prev;
        prev.next = node;
        node.prev = prev;

        node.next = tail;
        tail.prev = node;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */