public class Solution {
    public int findNthDigit(int n) {
        long nn = (long)n;
        long m = 9;
        long s = 1;
        long b = 1;
        while(nn >= 0) {
            if(nn <= m * b) {
                long num = s + (nn - 1) / b;
                char digit = Long.toString(num).charAt(((int)((nn - 1) % b)));
                return (int)(digit - '0');
            }
            
            nn -= b * m;
            m *= 10;
            s *= 10;
            b++;
        }
        
        return 0;
    }
}