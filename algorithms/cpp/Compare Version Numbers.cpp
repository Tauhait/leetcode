class Solution {
public:
    void version2num(const string& version, vector<int>& v) {
        string str = version;
        while(1) {
            size_t p = str.find('.');
            if(p != string::npos) {
                v.push_back(atoi(str.substr(0, p).c_str()));
                str = str.substr(p + 1);
            } else {
                v.push_back(atoi(str.substr(0).c_str()));
                break;
            }
        }
        
        while(v.back() == 0) {
            v.pop_back();
        }
    }
    
    int compareVersion(string version1, string version2) {
        vector<int> v1;
        vector<int> v2;
        version2num(version1, v1);
        version2num(version2, v2);
        size_t i = 0;
        while(i < v1.size() && i < v2.size()) {
            if(v1[i] < v2[i]) return -1;
            else if(v1[i] > v2[i]) return 1;
            else i++;
        }
        if(i == v1.size() && i == v2.size()) return 0;
        if(i < v1.size()) return 1;
        else return -1;
    }
};