
class Solution {
public:
    int minTotalDistance(vector<vector<int>>& grid) {
        int m = grid.size();
        if(m == 0) {
            return 0;
        }
        int n = grid[0].size();
        if(n == 0) {
            return 0;
        }
        
        vector<int> pxs;
        vector<int> pys;
        for(int i = 0;i < m;++i) {
            for(int j = 0;j < n;++j) {
                if(grid[i][j] == 1) {
                    pxs.push_back(i);
                }
            }
        }
        
        for(int j = 0;j < n;++j) {
            for(int i = 0;i < m;++i) {
                if(grid[i][j] == 1) {
                    pys.push_back(j);
                }
            }
        }
        
        int pxsize = pxs.size();
        int pysize = pys.size();
        
        int ret = 0;
        for(int i = 0;i < pxsize;++i) {
            ret += abs(pxs[i] - pxs[pxsize / 2]);
        }
        for(int j = 0;j < pysize;++j) {
            ret += abs(pys[j] - pys[pysize / 2]);
        }
        
        return ret;
    }
};