public class Solution {
    private boolean isPalindrom(String s) {
        int n = s.length();
        if(n < 2) return true;
        int i = 0, j = s.length() - 1;
        while(i < j) {
            if(s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
    
    public int countSubstrings(String s) {
        int n = s.length();
        int count = 0;
        for(int i = 0;i < n;++i) {
            for(int j = i;j < n;++j) {
                if(isPalindrom(s.substring(i, j + 1))) count++;
            }
        }
        return count;        
    }
}