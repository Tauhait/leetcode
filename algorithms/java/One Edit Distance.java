class Solution {
    public boolean isOneEditDistance(String s, String t) {
        if(s == null || t == null) return false;
        int m = s.length(), n = t.length();
        if(Math.abs(m - n) > 1) return false;
        
        int i = 0, j = 0, f = 0;
        while(i < m && j < n) {
            if(s.charAt(i) != t.charAt(j)) {
                if(f != 0) return false;
                f++;
                if(m == n) {i++;j++;}
                else if(m > n) i++;
                else j++;
            } else {
                i++;
                j++;
            }
        }
        if(i == m && j == n) return f == 1;
        return f == 0;
    }
}