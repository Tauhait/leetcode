class Solution {
public:
    int trap(vector<int>& height) {
        if(height.size() < 2) return 0;
        vector<int> left(height.size(), 0);
        vector<int> right(height.size(), 0);
        
        for(int i = 1;i < height.size();++i) {
            left[i] = max(left[i - 1], height[i - 1]);
        }
        
        int ret = 0, r = 0;
        for(int i = height.size() - 2;i >= 0;--i) {
            r = max(r, height[i + 1]);
            int h = min(left[i], r);
            if(height[i] < h) ret += (h - height[i]);
        }
        
        return ret;
    }
};