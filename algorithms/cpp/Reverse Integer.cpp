class Solution {
public:
    void digit2vector(const int& n, vector<int>& nums) {
        int m = n;
        if(n == 0) {
            nums.push_back(0);
            return ;
        }
        
        while(m) {
            nums.push_back(m % 10);
            m /= 10;
        }
        std::reverse(nums.begin(), nums.end());
    }
    
    int reverse(int x) {
        if(x >= 2147483643 || x <= -2147483643) return 0;
        int sign = 1;
        if(x < 0) {
            x = abs(x);
            sign = -1;
        }
        
        int n = 2147483647;
        vector<int> max_num;
        digit2vector(n, max_num);
        vector<int> x_vec;
        digit2vector(x, x_vec);
        std::reverse(x_vec.begin(), x_vec.end());
        
        if(max_num.size() == x_vec.size()) {
              int i = 0;
              while(i < max_num.size()) {
                  if(x_vec[i] > max_num[i]) return 0;
                  if(x_vec[i] < max_num[i]) break;
                  i++;
              }
        }
        
        int ret = 0;
        for(int i = 0;i < x_vec.size();i++) {
            ret = ret * 10 + x_vec[i];
        }
        
        return sign * ret;
    }
};
