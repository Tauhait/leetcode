public class WordDictionary {
    private class TrieNode {
        public TrieNode() {
            isWord = false;
            children = new TrieNode[26];
        }
        
        TrieNode[] children;
        boolean isWord;
    }
    
    TrieNode root;
    
    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new TrieNode();
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        TrieNode p = root;
        for(int i = 0;i < word.length();++i) {
            char c = word.charAt(i);
            if(p.children[c - 'a'] == null) {
                p.children[c - 'a'] = new TrieNode();
            }
            p = p.children[c - 'a'];
        }
        p.isWord = true;
    }
    
    private boolean dfs(TrieNode p, String word, int index) {
        if(p == null) {
            return false;
        }
        
        if(index == word.length()) {
            return p.isWord;
        }
        
        char c = word.charAt(index);
        if(c != '.') {
            if(p.children[c- 'a'] == null) {
                return false;
            } else {
                return dfs(p.children[c - 'a'], word, index + 1);
            }
        } else {
            for(int i = 0;i < 26;++i) {
                if(p.children[i] != null) {
                    if(dfs(p.children[i], word, index + 1)) {
                        return true;
                    }    
                }
            }
            
            return false;
        }
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        TrieNode p = root;
        return dfs(p, word, 0);
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */