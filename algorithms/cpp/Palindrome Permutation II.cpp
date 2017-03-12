class Solution {
public:
    int c;
    char odd_chr;
    vector<string> ret;
    vector<pair<char, int> > letters;
    int size;
    
    void dfs(const int& index, string & cur) {
        if(index == size) {
            int j = index;
            if(c != 0) {
                cur[j++] = odd_chr;
            }
            for(int i = size - 1;i >= 0;--i) {
                cur[j++] = cur[i];
            }
            ret.push_back(cur);
            
            return ;
        }
        
        for(size_t i = 0;i < letters.size();++i) {
            if(letters[i].second > 0) {
                letters[i].second--;
                cur[index] = letters[i].first;
                dfs(index + 1, cur);
                letters[i].second++;
            }
        }
    }
    
    vector<string> generatePalindromes(string s) {
        if(s.size() == 0) {
            return ret;
        }
        
        unordered_map<char, int> hash_table;
        for(size_t i = 0;i < s.size();++i) {
            hash_table[s[i]]++;
        }
        
        c = 0;
        odd_chr = 'a';
        for(unordered_map<char, int>::iterator it = hash_table.begin();it != hash_table.end();++it) {
            if(it->second % 2 == 1) {
                c++;
                odd_chr = it->first;
            }
        }
        if(c > 1) {
            return ret;
        }
      
        size = 0;
        for(unordered_map<char, int>::iterator it = hash_table.begin();it != hash_table.end();++it) {
            letters.push_back(make_pair(it->first, it->second / 2));
            size += it->second / 2;
        }
        
        string cur(s.size(), 'N');
        dfs(0, cur);
        
        return ret;
    }
};