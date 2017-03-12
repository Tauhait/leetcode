class Solution {
public:
    int ladderLength(string beginWord, string endWord, unordered_set<string>& wordList) {
        if(beginWord == endWord) {
            return 1;
        }
        
        unordered_set<string> existed;
        queue<string> q;
        q.push(beginWord);
        existed.insert(beginWord);
        int lev = 1;
        while(!q.empty()) {
            int s = q.size();
            lev++;
            for(int i = 0;i < s;++i) {
                string f = q.front();
                q.pop();
                string org = f;
                for(size_t j = 0;j < f.size();++j) {
                    for(char c = 'a'; c <= 'z';++c) {
                        if(c == f[j]) continue;
                        f[j] = c;
                        if(f == endWord) {
                            return lev;
                        }
                        if(wordList.find(f) != wordList.end() && existed.find(f) == existed.end()) {
                            q.push(f);
                            existed.insert(f);
                        }
                    
                        f[j] = org[j];
                    }
                }
            }
        }
        
        return 0;
    }
};