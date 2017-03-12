class Solution {
public:
    void reverseWords(string &s) {
        int i = 0, j = 0;
        while(j < s.size()) {
            if(s[j] == ' ') {
                if(i == 0 || s[i - 1] == ' ') {
                    j++;
                    continue;
                }
                s[i++] = ' ';
            } else {
                s[i++] = s[j];
            }
            j++;
        }
        while(i > 0 && s[i - 1] == ' ') i--;
        
        s = s.substr(0, i);
        
        
        reverse(s.begin(), s.end());
        
        int start = 0;
        for(int i = 0;i < s.size();++i) {
            if(s[i] == ' ') {
                reverse(s.begin() + start, s.begin() + i);
                
                start = i + 1;
            }
        }
        
        reverse(s.begin() + start, s.end());
    }
};