class Solution {
public:
    int maxArea(vector<int>& height) {
        if(height.size() == 0) return 0;
        int i = 0, j = height.size() - 1;
        int ret = 0;
        while(i < j) {
            int area = min(height[i], height[j]) * (j - i);
            ret = ret > area ? ret : area;
            if(height[i] > height[j]) {
                j--;
            } else {
                i++;
            }
        }
        
        return ret;
    }
};