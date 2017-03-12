public class Solution {
    public String longestPalindrome(String s) {
        if(s.length() == 0) return "";
        int res = 0;
        int resL = -1, resR = -1;
        // even length
        for(int i = 0;i < s.length() - 1;++i) {
            // i and i + 1 is the center
            if(s.charAt(i) != s.charAt(i + 1)) continue; 
            int l = i - 1;
            int r = i + 2;
            int len = 2;
            while(l >= 0 && r < s.length()) {
                if(s.charAt(l) == s.charAt(r)) {
                    l--;
                    r++;
                    len += 2;
                } else break;
            }
            if(len > res) {
                resL = l + 1;
                resR = r;
            }
            res = Math.max(res, len);
        }
        
        // odd length
        for(int i = 0; i < s.length();++i) {
            // i is the center
            int l = i - 1;
            int r = i + 1;
            int len = 1;
            while(l >= 0 && r < s.length()) {
                if(Character.compare(s.charAt(l), s.charAt(r)) == 0) {
                    l--;
                    r++;
                    len += 2;
                } else break;
            }
            if(len > res) {
                resL = l + 1;
                resR = r;
            }
            res = Math.max(res, len);
        }
        
        return s.substring(resL, resR);
    }
}