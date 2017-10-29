class Solution {
    public int divide(int dividend, int divisor) {
        if(divisor == 0) return Integer.MAX_VALUE;
        if(dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;
        
        long longDividend = dividend;
        long longDivisor = divisor;
        
        if(longDividend < 0) longDividend = -longDividend;
        if(longDivisor < 0) longDivisor = -longDivisor;
        
        int res = 0;
        while(longDividend >= longDivisor) {
            int shift = 0;
            long div = longDivisor;
            while(longDividend >= div) {
                shift++;
                div <<= 1;
            }
            shift--;
            longDividend -= (longDivisor << shift);
            res += (1 << shift);
        }
        
        if(dividend < 0 && divisor > 0) return -res;
        if(dividend > 0 && divisor < 0) return -res;
        return res;
    }
}