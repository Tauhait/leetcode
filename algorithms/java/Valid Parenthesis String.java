class Solution {
    public boolean checkValidString(String s) {
        int left = 0;
        int star = 0;
        for(char c: s.toCharArray()) {
            if(c == '*') star++;
            else if(c == '(') left++;
            else if(c == ')') {
                if(left > 0) left--;
                else if(star > 0) star--;
                else return false;
            }
        }
        if(left > star) return false;
        
        int right = 0;
        star = 0;
        for(int i = s.length() - 1;i >= 0;--i) {
            char c = s.charAt(i);
            if(c == '*') star++;
            else if(c == ')') right++;
            else if(c == '(') {
                if(right > 0) right--;
                else if(star > 0) star--;
                else return false;
            }
        }
        if(right > star) return false;
        return true;        
    }
}