class Solution {
public:
    vector<int> findSubstring(string s, vector<string>& words) {
        int n = words.size();
        unordered_map<string, int> hash_table;
        for(int i = 0;i < words.size();++i) {
            hash_table[words[i]]++;
        }
        vector<int> ret;
        int wl = words[0].size();
        int pl = wl * n;
        if(s.size() < pl) return ret;
        for(int i = 0;i <= s.size() - pl;i++) {
            unordered_map<string, int> cnt(hash_table);
            int f = 0;
            for(int j = 0;j < n;++j) {
                string w = s.substr(i + j * wl, wl);
                unordered_map<string, int>::iterator it = cnt.find(w);
                if(it == hash_table.end()) {
                    f = 1;
                    break;
                }
                if(it->second <= 0) {
                    f = 1;
                    break;
                }
                it->second--;
            }
            if(f == 0) ret.push_back(i);
        }
        
        return ret;
    }
};