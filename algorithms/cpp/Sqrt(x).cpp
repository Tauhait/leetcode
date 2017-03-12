class Solution {
public:
    int mySqrt(int x) {
        if(x <= 0) return 0;
        if(x == 1) return 1;
        
        double l = 1.0, h = x, m = 0.0;
        while(l < h && h - l > 1e-6) {
            m = (l + h) / 2;
            if(fabs(m * m - x) < 1e-6) break;
            else if(m * m > x) h = m;
            else l = m;
        }
        
        int ret = (int) m;
        if(fabs(ret + 1 - m) < 1e-6) return ret + 1;
        
        return ret;
    }
};