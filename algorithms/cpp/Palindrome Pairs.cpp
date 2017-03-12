class Solution {
public:
    bool isPalindrome(const string& word) {
        int n = word.size();
        if(n <= 1) return true;
        int i = 0, j = n - 1;
        while(i < j) {
            if(word[i] != word[j]) return false;
            i++;
            j--;
        }
        
        return true;
    }
    
    vector<vector<int> > palindromePairs(vector<string>& words) {
        set<pair<int, int> > ret;
        unordered_map<string, int> hash_table;
        for(int i = 0;i < words.size();++i) {
            string word = words[i];
            reverse(word.begin(), word.end());
            hash_table.insert(make_pair(word, i));
        }
        
        for(int i = 0;i < words.size();++i) {
            string word = words[i];
            for(size_t j = 0;j <= word.size();++j) {
                if(hash_table.find(word.substr(0, j)) != hash_table.end()) {
                    if(isPalindrome(word.substr(j))) {
                        if(i == hash_table[word.substr(0, j)]) continue;
                        ret.insert(make_pair(i, hash_table[word.substr(0, j)]));
                    }
                }
            }
            
            // 
            word = words[i];
            for(size_t j = 0;j <= word.size();++j) {
                if(hash_table.find(word.substr(j)) != hash_table.end()) {
                    if(isPalindrome(word.substr(0, j))) {
                        if(i == hash_table[word.substr(j)]) continue;
                        ret.insert(make_pair(hash_table[word.substr(j)], i));
                    }
                }
            }
        }
        
        vector<vector<int> > ret_val;
        for(set<pair<int, int> >::iterator it = ret.begin();it != ret.end();++it) {
            ret_val.push_back(vector<int>{it->first, it->second});
        }
        return ret_val;
    }
};