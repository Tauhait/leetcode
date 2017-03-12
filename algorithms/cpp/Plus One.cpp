class Solution {
public:
    vector<int> plusOne(vector<int>& digits) {
        int c = 1;
        int n = digits.size();
        if(n == 0) {
            digits.push_back(1);
            
            return digits;
        }
        
        for(int i = n - 1;i >= 0;--i) {
            int s = digits[i] + c;
            digits[i] = s % 10;
            c = s / 10;
        }
        
        if(c != 0) {
            digits.insert(digits.begin(), 1);
        }
        
        return digits;
    }
};