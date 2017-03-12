class Solution {
public:
    double myPow(double x, int n) {
        if(x == 0.0) return 0;
        if(x == 1) return 1;
        if(x == -1) {
            if(n % 2 == 0) return 1;
            else return -1;
        }
        if(n == 0) return 1.0;
        if(n == 1) return x;
        if(n < 0) return 1 / myPow(x, -1 * n);
        
        if(n % 2 == 1) {
            double y = myPow(x, n / 2);
            return y * y * x;
        } else {
            double y = myPow(x, n / 2);
            return y * y;
        }
    }
};