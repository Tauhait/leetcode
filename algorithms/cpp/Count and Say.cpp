class Solution {
public:
    string countAndSay(int n) {
        string pre = "1", cur;
        for(int i = 1;i < n;++i) {
            cur.clear();
            int c = 1;
            for(int j = 1;j < pre.size();++j) {
                if(pre[j] == pre[j - 1]) {
                    c++;
                } else {
                    cur += (c + '0');
                    cur += pre[j - 1];
                    c = 1;
                }
            }
            cur += (c + '0');
            cur += pre[pre.size() - 1];
            pre = cur;
        }
        
        return pre;
    }
};