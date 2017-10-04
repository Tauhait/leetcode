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

/////////
class Solution {
    private boolean isMatch(String s, int sIndex, String p, int pIndex) {
        if(sIndex == s.length() && pIndex == p.length()) return true;
        
        if(pIndex + 1 < p.length() && p.charAt(pIndex + 1) == '*') {
            if(isMatch(s, sIndex, p, pIndex + 2)) return true;
            
            if(sIndex < s.length() && (s.charAt(sIndex) == p.charAt(pIndex) || p.charAt(pIndex) == '.')) {
                return isMatch(s, sIndex + 1, p, pIndex);
            }
        } 
        
        if(sIndex >= s.length() || pIndex >= p.length()) return false;
        if(s.charAt(sIndex) == p.charAt(pIndex) || p.charAt(pIndex) == '.') {
            return isMatch(s, sIndex + 1, p, pIndex + 1);
        }
        return false;
    }
    
    public boolean isMatch(String s, String p) {
        if(s == null && p == null) return true;
        if(s.length() == 0 && p.length() == 0) return true;
        return isMatch(s, 0, p, 0);
    }
}