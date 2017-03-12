class Solution {
public:
    int romanToInt(string s) {
        unordered_map<char, int> roman_num;
        roman_num['I'] = 1;
        roman_num['V'] = 5;
        roman_num['X'] = 10;
        roman_num['L'] = 50;
        roman_num['C'] = 100;
        roman_num['D'] = 500;
        roman_num['M'] = 1000;
        
        int n = s.size(), ret = 0, i = n - 1;
        while(i >= 0) {
            if(i >= 1 && roman_num[s[i]] > roman_num[s[i - 1]]) {
                ret += roman_num[s[i]] - roman_num[s[i - 1]];
                i -= 2;
            } else {
                ret += roman_num[s[i]];
                i--;
            }
        }
        
        return ret;
    }
};