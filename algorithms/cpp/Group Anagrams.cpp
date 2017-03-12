class Solution {
public:
    static bool sortanagrams(const pair<string, string>& a, const pair<string, string>& b) {
        if(a.first < b.first) return true;
        return false;
    }
    
    vector<vector<string>> groupAnagrams(vector<string>& strs) {
        vector<pair<string, string> > anagrams;
        for(size_t i = 0;i < strs.size();++i) {
            string tmp = strs[i];
            sort(tmp.begin(), tmp.end());
            anagrams.push_back(make_pair(tmp, strs[i]));
        }
        
        sort(anagrams.begin(), anagrams.end(), sortanagrams);
        
        vector<vector<string> > ret;
        if(anagrams.size() == 0) return ret;
        vector<string> vec;
        vec.push_back(anagrams[0].second);
        for(size_t i = 1; i < anagrams.size();++i) {
            if(anagrams[i].first != anagrams[i - 1].first) {
                sort(vec.begin(), vec.end());
                ret.push_back(vec);
                vec.clear();
                vec.push_back(anagrams[i].second);
            } else {
                vec.push_back(anagrams[i].second);
            }
        }
        sort(vec.begin(), vec.end());
        if(vec.size() != 0) {
            ret.push_back(vec);
            vec.clear();
        }
        
        return ret;
    }
};