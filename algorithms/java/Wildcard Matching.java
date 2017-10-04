class Solution {
    public boolean isMatch(String s, String p) {
        int starPos = -1, MatchPos = -1;
        int i = 0, j = 0;
        while(i < s.length()) {
            if(j < p.length() && p.charAt(j) == '*') {
                starPos = j;
                MatchPos = i;
                j++;
                if(j == p.length()) return true;
            } else if(j < p.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?')) {
                i++;
                j++;
            } else {
                if(starPos == -1) return false;
                i = MatchPos + 1;
                MatchPos++;
                j = starPos + 1;
            }
        }
        
        if(i == s.length()) {
            while(j < p.length() && p.charAt(j) == '*') j++;
        }
        if(i == s.length() && j == p.length()) return true;
        return false;
    }
}