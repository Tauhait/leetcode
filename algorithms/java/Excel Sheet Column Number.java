public class Solution {
    public int titleToNumber(String s) {
        String rev = new StringBuilder(s).reverse().toString();
        int res = 0;
        int b = 1;
        for(int i = 0;i < rev.length();++i) {
            res += (rev.charAt(i) - 'A' + 1) * b;
            b *= 26;
        }
        
        return res;
    }
}