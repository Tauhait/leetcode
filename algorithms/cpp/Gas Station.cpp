class Solution {
public:
    int canCompleteCircuit(vector<int>& gas, vector<int>& cost) {
        vector<int> diff(gas.size());
        
        int sum = 0;
        for(int i = 0;i < gas.size();++i) {
            diff[i] = gas[i] - cost[i];
            sum += diff[i];
        }
        if(sum < 0) return -1;
        
        int ret = 0;
        sum = 0;
        for(int i = 0;i < gas.size();++i) {
            sum += diff[i];
            if(sum < 0) {
                ret = i + 1;
                sum = 0;
            }
        }
        
        return ret;
    }
};