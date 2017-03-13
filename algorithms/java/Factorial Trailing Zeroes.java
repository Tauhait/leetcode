public class Solution {
    public int trailingZeroes(int n) {
        // number of factor of 5
        int num = n;
        int res = 0;
        while(num != 0) {
            res += num / 5;
            num /= 5;
        }
        
        return res;
    }
}