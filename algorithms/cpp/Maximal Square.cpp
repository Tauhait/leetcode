class Solution {
public:
    int maximalSquarebyHeight(vector<int>& height) {
        height.push_back(-1);
        stack<int> s;
        int ret = 0;
        for(int i = 0;i < height.size();++i) {
            if(s.empty() || height[i] >= height[s.top()]) {
                s.push(i);
            } else {
                int t = s.top();
                s.pop();
                int l = s.empty() ? i : i - s.top() - 1;
                l = min(l, height[t]);
                l *= l;
                ret = ret > l ? ret : l;
                i--;
            }
        }
        height.pop_back();
        
        return ret;
    }
    
    int maximalSquare(vector<vector<char> >& matrix) {
        int ret = 0;
        int m = matrix.size();
        if(m == 0) return 0;
        int n = matrix[0].size();
        
        vector<int> height(n, 0);
        for(int i = 0;i < m;++i) {
            for(int j = 0;j < n;++j) {
                if(i == 0) {
                    height[j] = matrix[0][j] - '0';
                } else {
                    if(matrix[i][j] == '0') {
                        height[j] = 0;
                    } else {
                        height[j] = height[j] + 1;
                    }
                } 
            }
            int area = maximalSquarebyHeight(height);
            ret = ret > area ? ret : area;
        }
        
        return ret;
    }
};