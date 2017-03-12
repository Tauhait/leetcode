class Solution {
public:
    int numDecodings(string s) {
        int n = s.size();
        if(n == 0 || s[0] == '0') return 0;
        
        int pre_pre = 1, pre = 1, cur = 1;
        for(int i = 2;i <= n;++i) {
            cur = 0;
            // decode independently
            if(s[i - 1] >= '1' && s[i - 1] <= '9') {
                cur += pre;
            }
            
            
            // decode with the previous digit
            if(s[i - 2] == '1') {
                cur += pre_pre;
            }
            
            if(s[i - 2] == '2' && s[i - 1] >= '0' && s[i - 1] <= '6') {
                cur += pre_pre;
            }
            pre_pre = pre;
            pre = cur;

        }

        return cur;
    }
};