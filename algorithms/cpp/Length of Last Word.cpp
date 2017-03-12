class Solution {
public:
    int lengthOfLastWord(string s) {
        if(s.size() == 0) return 0;
        int ret = 0;
        int i = s.size() - 1;
        while(s[i] == ' ' && i >= 0) i--;
        if(i < 0) return 0;
        while(s[i] != ' ' && i >= 0) i--, ret++;
    
    
        return ret;
    }
};