public class Solution {
    public int mySqrt(int x) {
        if(x <= 0) return 0;
        int res = -1;
        double low = 0, high = x;
        while(low < high) {
            double m =  low +  (high - low) / 2;
            if(Math.abs(m * m - x) < 0.0001) {
                res = (int) m;
                break;
            } else if(m * m > x) {
                high = m;
            } else {
                low = m;
            }
        }
        
        if(res == -1) {
            res = (int) low;
        }
        if((res + 1) * (res + 1) == x) {
            return res + 1;
        }
        return res;
    }
}

/////////////////////////
class Solution {
    public int mySqrt(int x) {
        if(x < 0) throw new IllegalArgumentException();
        long l = 0, r = x;
        while(l < r) {
            long m = l + (r - l + 1) / 2;
            if(m * m > x) r = m - 1;
            else l = m;
        }
        return (int)l;
    }
}