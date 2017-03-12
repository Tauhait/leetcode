public class Solution {
    public int reverse(int x) {
        long y = x;
        y = Math.abs(y);
        
        long s = 0;
        while(y != 0) {
            s = s * 10 + y % 10;
            y = y / 10;
        }
        
        s = s * Integer.signum(x);
        
        if(s > Integer.MAX_VALUE) return 0;
        if(s < Integer.MIN_VALUE) return 0;
        
        return (int) s;
    }
}