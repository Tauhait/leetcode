class Solution {
public:
    static bool groupsort(const pair<vector<int>, string>& a, const pair<vector<int>, string>& b) {
        size_t len = a.first.size();
        for(size_t i = 0;i < len;++i) {
            if(a.first[i] < b.first[i]) return true;
            if(a.first[i] > b.first[i]) return false;
        }
        return false;
    }
    
    bool equal(const vector<int>& a, const vector<int>& b) {
        for(size_t i = 0;i < a.size();++i) {
            if(a[i] != b[i]) return false;
        }
        return true;
    }

    vector<vector<string> > groupStrings(vector<string>& strings) {
        map<int, vector<string> > hash_table;
        for(size_t i = 0;i < strings.size();++i) {
            hash_table[strings[i].size()].push_back(strings[i]);
        }
        
        vector<vector<string> > ret;
        if(strings.size() == 0) return ret;
        for(map<int, vector<string> >::iterator it = hash_table.begin(); it != hash_table.end();++it) {
            vector<pair<vector<int>, string> > group;
            for(size_t i = 0;i < it->second.size();++i) {
                vector<int> tmp;
                for(size_t j = 0;j < it->second[i].size();++j) {
                    int val = it->second[i][j] - it->second[i][0];
                    if(val < 0) val += 26;
                    tmp.push_back(val);
                }
                group.push_back(make_pair(tmp, it->second[i]));
            }
        
            sort(group.begin(), group.end(), groupsort);
            vector<string> tmp;
            tmp.push_back(group[0].second);
            for(size_t i = 1;i < group.size();++i) {
                if(equal(group[i].first, group[i - 1].first)) {
                    tmp.push_back(group[i].second);
                } else {
                    sort(tmp.begin(), tmp.end());
                    ret.push_back(tmp);
                    tmp.clear();
                    tmp.push_back(group[i].second);
                }
            }
            if(tmp.size() != 0) {
                sort(tmp.begin(), tmp.end());
                ret.push_back(tmp);
                tmp.clear();   
            }
        }
        
        return ret;
    }
};