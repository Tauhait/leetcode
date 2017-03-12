class Solution {
public:
    vector<string> generatePossibleNextMoves(string s) {
        int n = s.size();
        vector<string> ret;
        if(n < 2) {
            return ret;
        }
        for(int i = 1;i < n;++i) {
            if(s[i - 1] == '+' && s[i] == '+') {
                string str = s;
                str[i] = '-';
                str[i - 1] = '-';
                ret.push_back(str);
            }
        }
        
        return ret;
    }
};