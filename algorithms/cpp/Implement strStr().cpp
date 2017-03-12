class Solution {
public:
    int strStr(string haystack, string needle) {
        size_t p = haystack.find(needle);
        if(p == string::npos) return -1;
        
        return p;
    }
};