class Solution {
    private boolean isPalindrome(String s) {
        int n = s.length();
        if(n <= 1) return true;
        int i = 0, j = n - 1;
        while(i < j) {
            if(s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
    
    public boolean validPalindrome(String s) {
        int n = s.length();
        if(n <= 1) return true;
        int i = 0, j = n - 1;
        while(i < j) {
            if(s.charAt(i) != s.charAt(j)) {
                String s1 = s.substring(i + 1, j + 1);
                String s2 = s.substring(i, j);
                if(isPalindrome(s1) || isPalindrome(s2)) return true;
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}