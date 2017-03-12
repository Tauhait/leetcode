class Solution {
public:
    bool isPalindrome(string s) {
        int n = s.size();
        if(n == 0 || n == 1) return true;
        
        int i = 0, j = n - 1;
        while(i < j) {
            if(!isalnum(s[i])) {
                i++;
                continue;
            }
            if(!isalnum(s[j])) {
                j--;
                continue;
            }
            int c1 = toupper(s[i]);
            int c2 = toupper(s[j]);
            if(c1 != c2) return false;
            i++;
            j--;
        }
        
        return true;
    }
};