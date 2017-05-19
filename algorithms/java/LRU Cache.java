public class LRUCache {
    private class Node {
        private int key;
        private int value;
        private Node next;
        private Node previous;
        
        public Node(int key, int value, Node next, Node previous) {
            this.key = key;
            this.value = value;
            this.next = next;
            this.previous = previous;
        }
    }
    
    // Double-Linked List
    // head is the least used element
    // tail is the most recently used element
    private Node head;
    private Node tail;
    private int capacity;
    private int size;
    
    // Map
    HashMap<Integer, Node> cache = new HashMap<>();
    
    public LRUCache(int capacity) {
        head = new Node(-1, -1, null, null);
        tail = new Node(-1, -1, null, null);
        head.next = tail;
        tail.previous = head;
        size = 0;
        
        this.capacity = capacity;
    }
    
    private void moveToTail(Node node) {
        // move out node
        node.previous.next = node.next;
        node.next.previous = node.previous;
        
        // insert node before tail
        node.previous = tail.previous;
        node.next = tail;
        tail.previous.next = node;
        tail.previous = node;
    }
    
    public int get(int key) {
        if(cache.containsKey(key)) {
            Node node = cache.get(key);
            moveToTail(node);
            return node.value;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(cache.containsKey(key)) {
            Node node = cache.get(key);
            node.value = value;
            moveToTail(node);
        } else {
            if(size == capacity) {
                Node node = head.next;
                head.next = head.next.next;
                node.next.previous = node.previous;
                cache.remove(node.key);
                size--;
            }
            Node node = new Node(key, value, null, null);
            node.previous = tail.previous;
            node.next = tail;
            tail.previous.next = node;
            tail.previous = node;
            cache.put(key, node);
            size++;
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

public class LRUCache {
    private LinkedHashMap<Integer, Integer> cache = new LinkedHashMap<>();
    private int capacity;
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
    }
    
    public int get(int key) {
        if(cache.containsKey(key)) {
            int val = cache.get(key);
            cache.remove(key);
            cache.put(key, val);
            return cache.get(key);
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(cache.containsKey(key)) {
            cache.remove(key);
            cache.put(key, value);
        } else {
            if(cache.size() == capacity) {
                Iterator<Map.Entry<Integer, Integer> > it = cache.entrySet().iterator();
                it.next();
                it.remove();
            }
            cache.put(key, value);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */