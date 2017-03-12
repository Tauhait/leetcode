class Solution {
public:
    int minimumTotal(vector<vector<int>>& triangle) {
        int n = triangle.size();
        if(n == 0) return 0;
        if(n == 1) return triangle[0][0];
        vector<int> opt_pre(n, INT_MAX);
        vector<int> opt_cur(n, INT_MAX);
        
        opt_pre[0] = triangle[0][0];
        for(int i = 1;i < n;++i) {
            opt_cur[0] = opt_pre[0] + triangle[i][0];
            for(int j =1;j < i;j++) {
                opt_cur[j] = min(opt_pre[j], opt_pre[j - 1]) + triangle[i][j];
            }
            opt_cur[i] = opt_pre[i - 1] + triangle[i][i];
            
            opt_pre = opt_cur;
        }
        int ret = INT_MAX;
        for(int i = 0;i < opt_pre.size();++i) {
            ret = min(ret, opt_pre[i]);
        }
        
        return ret;
    }
};