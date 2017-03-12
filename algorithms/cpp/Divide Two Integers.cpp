class Solution {
public:
    int divide(int dividend, int divisor) {
        if(divisor == 0) {
            return INT_MAX;
        }
        if(divisor == 1) return dividend;
        if(divisor == -1){
            if(dividend == INT_MIN) {
                return INT_MAX;
            } else {
                return -dividend;
            }
        }
        
        unsigned int div = dividend;
        unsigned int dis = divisor;
        
        if(dividend < 0) div = -div;
        if(divisor < 0) dis = -dis;
        
        unsigned int ordis = dis;
        int left = 0;
        while(dis < div) {
            dis <<= 1;
            left++;
        }
        
        int res = 0;
        while(div >= ordis) {
            if(div >= dis) {
                div -= dis;
                res += 1 << left;
            }
            dis >>= 1;
            left--;
        }
        
        if(dividend < 0 && divisor > 0) return -res;
        if(dividend > 0 && divisor < 0) return -res;
        return res;
    }
};