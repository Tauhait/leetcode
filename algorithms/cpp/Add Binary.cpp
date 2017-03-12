class Solution {
public:
    string addBinary(string a, string b) {
        reverse(a.begin(), a.end());
        reverse(b.begin(), b.end());
        
        string c;
        int l = 0, carry = 0;
        while(l < a.size() && l < b.size()) {
            int s = carry + a[l] - '0' + b[l] - '0';
            c += char(s % 2 + '0');
            carry = s / 2;
            l++;
        }
        
        while(l < a.size()) {
            int s = carry + a[l] - '0';
            c += char(s % 2 + '0');
            carry = s / 2;
            l++;
        }
        
        while(l < b.size()) {
            int s = carry + b[l] - '0';
            c += char(s % 2 + '0');
            carry = s /2;
            l++;
        }
        if(carry != 0) {
            c += char(carry + '0');
        }
        
        reverse(c.begin(), c.end());
        return c;
    }
};