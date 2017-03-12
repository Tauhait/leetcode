class TrieNode {
public:
    // Initialize your data structure here.
    bool isWord;
    TrieNode* children[26];
        
    TrieNode() {
        isWord = false;
        for(int i = 0;i < 26;++i) {
            children[i] = NULL;
        }
    }
};

class Trie {
public:
    Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    void insert(string word) {
        if(word.size() == 0) {
            return ;
        }
        
        TrieNode* p = root;
        for(int i = 0;i < word.size();++i) {
            if(p->children[word[i] - 'a']) {
                p = p->children[word[i] - 'a'];
            } else {
                TrieNode* q = new TrieNode();
                p->children[word[i] - 'a'] = q;
                p = p->children[word[i] - 'a'];
            }
        }
        
        p->isWord = true;
    }

    // Returns if the word is in the trie.
    bool search(string word) {
        if(word.size() == 0) {
            return true;
        }
        
        TrieNode* p = root;
        for(int i = 0;i < word.size();++i) {
            if(p->children[word[i] - 'a'] == NULL) {
                return false;
            } else {
                p = p->children[word[i] - 'a'];
            }
        }
        
        return p->isWord;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    bool startsWith(string prefix) {
        if(prefix.size() == 0) {
            return true;
        }
        
        TrieNode* p = root;
        for(int i = 0;i < prefix.size();++i) {
            if(p->children[prefix[i] - 'a'] == NULL) {
                return false;
            } else {
                p = p->children[prefix[i] - 'a'];
            }
        }
        
        return true;        
    }

private:
    TrieNode* root;
};

// Your Trie object will be instantiated and called as such:
// Trie trie;
// trie.insert("somestring");
// trie.search("key");