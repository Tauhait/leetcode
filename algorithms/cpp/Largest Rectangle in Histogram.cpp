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
        
        return ret;
    }
};