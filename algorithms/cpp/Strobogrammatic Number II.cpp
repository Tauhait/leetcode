class Solution {
public:
    vector<string> ret;
    const string s1[3] = {"0", "1", "8"};
    const string s2[4] = {"11", "69", "88", "96"};
    
    void dfs(const int& n, const int&c, const int& cur, string& str) {
        if(cur == c) {
            if(n % 2 == 0) {
                ret.push_back(str);
            } else {
                for(int j = 0;j < 3;++j) {
                    str[n / 2] = s1[j][0];
                    ret.push_back(str);
                }
            }
            return ;
        }
        
        for(int i = 0;i < 4;++i) {
            str[cur] = s2[i][0];
            str[n - cur - 1] = s2[i][1];
            dfs(n, c, cur + 1, str);
        }
        if(cur != 0) {
            str[cur] = '0';
            str[n - cur - 1] = '0';
            dfs(n, c, cur + 1, str);  
        }
    }
    
    vector<string> findStrobogrammatic(int n) {
        string str(n, 'N');
        int c = n / 2;
        dfs(n, c, 0, str);
        
        return ret;
    }
};