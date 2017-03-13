public class Solution {
    private boolean isAlphanumeric(char c) {
        if(Character.isLetter(c) || Character.isDigit(c)) {
            return true;
        }
        return false;
    }
    
    public boolean isPalindrome(String s) {
        int n = s.length();
        if(n == 0 || n == 1) {
            return true;
        }
        
        int i = 0, j = n - 1;
        while(i < j) {
            while(i < n && !isAlphanumeric(s.charAt(i))) i++;
            while(j >= 0 && !isAlphanumeric(s.charAt(j))) j--;
            if(i >= j) break;
            else {
                char ci = s.charAt(i);
                char cj = s.charAt(j);
                if(ci == cj) {
                    i++;
                    j--;
                } else {
                    if(Character.isLetter(ci) && Character.isLetter(cj)) {
                        ci = Character.toLowerCase(ci);
                        cj = Character.toLowerCase(cj);
                        if(ci == cj) {
                            i++;
                            j--;
                        } else {
                            return false;
                        }
                    } else {
                        return false;
                    }
                }
            }
        }
        
        return true;
    }
}