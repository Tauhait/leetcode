class Solution {
public:
    unordered_map<string, bool> hash_table;
    bool canWin(string s) {
        if(hash_table.find(s) != hash_table.end()) {
            return hash_table[s];
        }
        
        if(s.size() < 2) {
            return false;
        }
        
        for(size_t i = 0;i < s.size();++i) {
            if(s[i] == '+' && s[i - 1] == '+') {
                string str = s;
                str[i] = '-';
                str[i - 1] = '-';
                if(!canWin(str)) {
                    hash_table.insert(make_pair(s, true));
                    string str = s;
                    reverse(str.begin(), str.end());
                    hash_table.insert(make_pair(str, true));
                    return true;
                }
            }
        }
    
        hash_table.insert(make_pair(s, false));
        
        string str = s;
        reverse(str.begin(), str.end());
        hash_table.insert(make_pair(str, false));
        
        return false;
    }
};