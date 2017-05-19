public class LFUCache {
    private class Node {
        private int key;
        private int value;
        private int frequency;
        
        public Node(int key, int value, int frequency) {
            this.key = key;
            this.value = value;
            this.frequency = frequency;
        }
    }
    
    private int capacity;
    private int size;
    private int minFrequency;
    private HashMap<Integer, Node> cache = new HashMap<>();
    private HashMap<Integer, LinkedHashMap<Integer, Node> > frequencyMap = new HashMap<>();
    
    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.minFrequency = 0;
        this.size = 0;
    }
    
    public int get(int key) {
        if(cache.containsKey(key)) {
            Node node = cache.get(key);
            int freq = node.frequency;
            frequencyMap.get(freq).remove(key);
            if(minFrequency == freq && frequencyMap.get(freq).size() == 0) {
                frequencyMap.remove(freq);
                minFrequency++;
            }
            node.frequency = node.frequency + 1;
            if(!frequencyMap.containsKey(node.frequency)) {
                frequencyMap.put(node.frequency, new LinkedHashMap<>());
            }
            frequencyMap.get(node.frequency).put(key, node);
            return node.value;
        }
        
        return -1;
    }
    
    public void put(int key, int value) {
        if(cache.containsKey(key)) {
            Node node = cache.get(key);
            int freq = node.frequency;
            frequencyMap.get(freq).remove(key);
            if(minFrequency == freq && frequencyMap.get(freq).size() == 0) {
                frequencyMap.remove(freq);
                minFrequency++;
            }
            node.frequency = node.frequency + 1;
            node.value = value;
            if(!frequencyMap.containsKey(node.frequency)) {
                frequencyMap.put(node.frequency, new LinkedHashMap<>());
            }
            frequencyMap.get(node.frequency).put(key, node);
        } else {
            if(capacity == 0) {
                return;
            }
            if(capacity == size) {
                LinkedHashMap<Integer, Node> map = frequencyMap.get(minFrequency);
                Iterator<Map.Entry<Integer, Node> > it = map.entrySet().iterator();
                Map.Entry<Integer, Node> node = it.next();
                cache.remove(node.getKey());
                it.remove();
                size--;    
            }
            
            Node node = new Node(key, value, 1);
            if(!frequencyMap.containsKey(node.frequency)) {
                frequencyMap.put(node.frequency, new LinkedHashMap<>());
            }
            frequencyMap.get(node.frequency).put(key, node);
            cache.put(key, node);
            minFrequency = 1;
            size++;
        }
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */