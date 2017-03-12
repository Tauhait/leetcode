class Solution {
public:
    vector<string> ret;
    void dfs(const int& n, const int& left, const int& index, const int& unpair, string& cur) {
        if(n == left) {
            int j = index;
            while(j < 2 * n) {
                cur[j++] = ')';
            }
            ret.push_back(cur);
            return ;
        }
        
        if(unpair > 0) {
            cur[index] = ')';
            dfs(n,  left, index + 1, unpair - 1, cur);
        }
        
        cur[index] = '(';
        dfs(n, left + 1, index + 1, unpair + 1, cur);
    }
    
    vector<string> generateParenthesis(int n) {
        string cur(2 * n, 'N');
        
        dfs(n, 0, 0, 0, cur);
        
        return ret;
    }
};