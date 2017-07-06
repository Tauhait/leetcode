public class Solution {
    public boolean judgeSquareSum(int c) {
        int n = (int) Math.sqrt(c);
        for(int a = 0;a <= n;++a) {
            int bSquare = c - a * a;
            long b = Math.round(Math.sqrt(bSquare));
            if(b * b == bSquare) {
                return true;
            }
        }
        return false;        
    }
}