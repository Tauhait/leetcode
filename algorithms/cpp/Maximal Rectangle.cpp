class Solution {
public:
    int largestRectangleArea(vector<int>& height) {
        height.push_back(0);
        stack<int> s;
        int ret = 0;
        int i = 0;
        while(i < height.size()) {
            if(s.empty() || height[i] > height[s.top()]) {
                s.push(i);
                i++;
            } else {
                int h = s.top();
                s.pop();
                int p = s.empty() ? -1 : s.top();
                ret = max(ret, height[h] * (i - p - 1));
            }
        }
        height.pop_back();
        
        return ret;
    }
    
    int maximalRectangle(vector<vector<char>>& matrix) {
        int m = matrix.size();
        if(m == 0) return 0;
        int n = matrix[0].size();
        int ret = 0;
        vector<int> height(n, 0);
        for(int i = 0;i < m;++i) {
            for(int j = 0;j < n;++j) {
                if(i == 0) height[j] = matrix[i][j] - '0';
                else height[j] = matrix[i][j] == '1' ? height[j] + 1 : 0;
            }
            ret = max(ret, largestRectangleArea(height));
        }
        
        return ret;
    }
};