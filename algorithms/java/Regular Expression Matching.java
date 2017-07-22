public class Solution {
    private boolean isMatch(String s, int indexS, String p, int indexP) {
        if(indexS == s.length() && indexP == p.length()) return true;
        if(indexP == p.length()) {
            while(indexS < s.length()) {
                if(s.charAt(indexS) != '*') {
                    if(indexS + 1 < s.length() && s.charAt(indexS + 1) == '*') indexS += 2;
                    else return false;
                }
                else indexS++;
            }
            if(indexS == s.length()) return true;
            return false;
        }
        if(indexS == s.length()) return false;
        if(s.charAt(indexS) == '*')  return false;
        
        if(indexS + 1 < s.length() && s.charAt(indexS + 1) == '*') {
            if(isMatch(s, indexS + 2, p, indexP)) return true;
            for(int i = 1;i <= p.length() - indexP;++i) {
                if(p.charAt(indexP + i - 1) == s.charAt(indexS) || s.charAt(indexS) == '.') {
                    if(isMatch(s, indexS + 2, p, indexP + i)) return true;
                } else {
                    return false;
                }
            }
        }
        
        if(s.charAt(indexS) == p.charAt(indexP) || s.charAt(indexS) == '.') {
            return isMatch(s, indexS + 1, p, indexP + 1);
        }
        return false;
    }
    
    public boolean isMatch(String s, String p) {
        return isMatch(p, 0, s, 0);
    }
}