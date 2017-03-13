public class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        int[] res = new int[n];
        int c = 1;
        for(int i = n - 1;i >= 0;--i) {
            int s = c + digits[i];
            res[i] = s % 10;
            c = s / 10;
        }
        if(c == 0) {
            return res;
        } else {
            int[] ress = new int[n + 1];
            ress[0] = c;
            for(int i = 0;i < n;++i) {
                ress[i + 1] = res[i];
            }
            return ress;
        }
    }
}