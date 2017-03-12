class Solution {
public:
    void digit2vector(int n, vector<int>& nums) {
        if(n == 0) {
            nums.push_back(0);
            return ;
        }
        while(n) {
            nums.push_back(n % 10);
            n /= 10;
        }
    }
    
    bool isHappy(int n) {
        if(n == 1) return true;
        unordered_set<int> hash_table;
        hash_table.insert(n);
        int cur = n;
        while(1) {
            vector<int> nums;
            digit2vector(cur, nums);
            int new_num = 0;
            for(int i = 0;i < nums.size();++i) {
                new_num += nums[i] * nums[i];
            }
            if(hash_table.find(new_num) != hash_table.end()) return false;
            
            if(new_num == 1) return true;
            
            hash_table.insert(new_num);
            cur = new_num;
        }
    }
};