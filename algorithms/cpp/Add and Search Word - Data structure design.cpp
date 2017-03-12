class TrieNode {
public:
    // Initialize your data structure here.
    bool word;
    TrieNode* next[26];
    
    TrieNode() {
        word = false;
        for(int i = 0;i < 26;++i) {
            next[i] = NULL;
        }
    }
};

class Trie {
public:
    Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    void insert(string s) {
        TrieNode* p = root;
        for(int i = 0;i < s.size();++i) {
            if(p->next[s[i] - 'a'] == NULL) {
                TrieNode* tmp = new TrieNode;
                p->next[s[i] - 'a'] = tmp;
            } 
            
            p = p->next[s[i] - 'a'];
            
            if(i + 1 == s.size()) {
                p->word = true;
            }
        }
    }

    // Returns if the word is in the trie.
    bool search(string key) {
        TrieNode* p = root;
        for(int i = 0;i < key.size();++i) {
            if(p->next[key[i] - 'a'] == NULL) {
                return false;
            } else {
                p = p->next[key[i] - 'a'];
            }
        }
        if(p->word == true) {
            return true;
        }
        
        return false;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    bool startsWith(string prefix) {
        TrieNode* p = root;
        for(int i = 0;i < prefix.size();++i) {
            if(p->next[prefix[i] - 'a'] == NULL) {
                return false;
            } else {
                p = p->next[prefix[i] - 'a'];
            }
        }
        
        return true;
    }

public:
    TrieNode* root;
};

////////////////

class WordDictionary {
public:

    // Adds a word into the data structure.
    void addWord(string word) {
        trie.insert(word);
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    void dfs(int d, const int& n, const string& word, TrieNode* p) {
        if(find == true) return ;
        if(d == n) {
            if(p->word) {
                find = true;
            }
            return;
        }
        if(find == true) return;
        
        if(word[d] != '.') {
            if(p->next[word[d] - 'a'] == NULL) return ;
            dfs(d + 1, n, word, p->next[word[d] - 'a']);
        } else {
            for(int i = 0;i < 26;++i) {
                if(p->next[i] != NULL) {
                    dfs(d + 1, n, word, p->next[i]);
                }
            }
        }
    }
    
    bool search(string word) {
        TrieNode* p = trie.root;
        find = false;
         dfs(0, word.size(), word, p);
        
        return find;
    }
    
    
    
    bool find;
    Trie trie;
};

// Your WordDictionary object will be instantiated and called as such:
// WordDictionary wordDictionary;
// wordDictionary.addWord("word");
// wordDictionary.search("pattern");