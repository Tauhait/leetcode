class Solution {
    private boolean isAlphanumeric(char c) {
        return Character.isLetter(c) || Character.isDigit(c);  
    }
    
    public boolean isPalindrome(String s) {
        if(s == null) return false;
        if(s.isEmpty()) return true;
        int i = 0, j = s.length() - 1;
        while(i < j) {
            while(i < j && !isAlphanumeric(s.charAt(i))) i++; 
            while(i < j && !isAlphanumeric(s.charAt(j))) j--;
            if(i < j) {
                char ci = Character.toUpperCase(s.charAt(i));
                char cj = Character.toUpperCase(s.charAt(j));
                if(ci != cj) return false;
                i++;
                j--;
            }
        }
        return true;
    }
}