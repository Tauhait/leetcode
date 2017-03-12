public class Solution {
    public int longestPalindromeSubseq(String s) {
        if(s.length() ==0 || s.length() == 1) return s.length();
        int[][] opt = new int[s.length()][s.length()];
        for(int i = 0;i < s.length();++i) {
            opt[i][i] = 1;
            if(i + 1 < s.length()) {
                if(s.charAt(i) == s.charAt(i + 1)) {
                    opt[i][i + 1] = 2;
                } else {
                    opt[i][i + 1] = 1;
                }
            }
        }
        
        for(int d = 3;d <= s.length();++d) {
            for(int i = 0;i < s.length();++i) {
                if(i + d - 1 >= s.length()) break;
                opt[i][i + d - 1] = Math.max(opt[i + 1][i + d - 2], Math.max(opt[i][i + d - 2], opt[i + 1][i + d - 1]));
                if(s.charAt(i) == s.charAt(i + d - 1)) {
                    opt[i][i + d - 1] = Math.max(opt[i][i + d - 1], opt[i + 1][i + d - 2] + 2);
                }
            }
        }
        
        return opt[0][s.length() - 1];
    }
}