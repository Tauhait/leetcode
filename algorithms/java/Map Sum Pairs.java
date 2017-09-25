class MapSum {
    private static class TrieNode {
        private Integer val;
        private Map<Character, TrieNode> children;
        
        public TrieNode() {
            children = new HashMap<>();
        }
    } 
    
    private static class Trie {
        private TrieNode root;
        
        public Trie() {
            root = new TrieNode();
        }
        
        public void insert(String word, int val) {
            TrieNode p = root;
            for(char c: word.toCharArray()) {
                p.children.putIfAbsent(c, new TrieNode());
                p = p.children.get(c);
            }
            p.val = val;
        }
        
        public TrieNode prefix(String prefix) {
            TrieNode p = root;
            for(char c: prefix.toCharArray()) {
                if(!p.children.containsKey(c)) return null;
                p = p.children.get(c);
            }
            return p;
        }
        
        public int sum(TrieNode node) {
            if(node == null) return 0;
            int s = node.val == null ? 0 : node.val;
            for(Map.Entry<Character, TrieNode> entry: node.children.entrySet()) {
                s += sum(entry.getValue());
            }
            return s;
        }
    }
    
    private Trie trie;
    
    /** Initialize your data structure here. */
    public MapSum() {
        trie = new Trie();
    }
    
    public void insert(String key, int val) {
        trie.insert(key, val);  
    }
    
    public int sum(String prefix) {
        TrieNode node = trie.prefix(prefix);
        return trie.sum(node);
    }
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */