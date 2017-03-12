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
    void insert(const string& s) {
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
    bool search(const string& key) const {
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
    bool startsWith(const string& prefix) const {
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

private:
    TrieNode* root;
};

int dir[4][2] = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};

class Solution {
public:
    void dfs(const string& prefix, const int& i, const int& j, vector<vector<int> >& f,
        const vector<vector<char > >& board, const Trie& word_trie,
        const int& m, const int& n, set<string>& ret) {
        if(!word_trie.startsWith(prefix)) return ;
        if(word_trie.search(prefix)) {
            ret.insert(prefix);
        }
        
        for(int k = 0;k < 4;++k) {
            int r = i + dir[k][0];
            int c = j + dir[k][1];
            if(r >= 0 && r < m && c >= 0 && c < n && f[r][c] == 0) {
                f[r][c] = 1;
                dfs(prefix + board[r][c], r, c, f, board, word_trie, m, n, ret);
                f[r][c] = 0;
            }
        }
    }
    
    vector<string> findWords(vector<vector<char> >& board, vector<string>& words) {
        set<string> ret;
        vector<string> ret2;
        int m = board.size();
        if(m == 0) return ret2;
        int n = board[0].size();
        
        Trie word_trie;
        for(int i = 0;i < words.size();++i) {
            word_trie.insert(words[i]);
        }
    
       vector<vector<int> > f(m, vector<int>(n, 0));
        for(int i = 0;i < m;++i) {
            for(int j = 0;j < n;++j) {
                if(f[i][j] == 0) {
                    f[i][j] = 1;
                    string p= "a";
                    p[0] = board[i][j];
                    dfs(p, i, j, f, board, word_trie, m, n, ret);
                    f[i][j] = 0;
                }
            }
        }
        
        for(set<string>::const_iterator it = ret.begin(); it != ret.end();++it) {
            ret2.push_back(*it);
        }
        return ret2;
    }
};