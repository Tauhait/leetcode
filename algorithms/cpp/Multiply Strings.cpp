class Solution {
public:
    string add(const string& num1, const string& num2) {
        string res;
        int c = 0;
        int i = 0;
        while(i < num1.size() && i < num2.size()) {
            int s = num1[i] - '0' + num2[i] - '0' + c;
            c = s / 10;
            res += s % 10 + '0';
            i++;
        }
        while(i < num1.size()) {
            int s = num1[i] - '0' + c;
            c = s / 10;
            res += s % 10 + '0';
            i++;
        }
        while(i < num2.size()) {
            int s = num2[i] - '0' + c;
            c = s / 10;
            res += s % 10 + '0';
            i++;
        }
        if(c != 0) {
            res += c + '0';
        }
        
        return res;
    }
    
    string multiply_1digit(const string& num, const int& m) {
        string res;
        int c = 0;
        int i = 0;
        while(i < num.size()) {
            int s = (num[i] - '0') * m + c;
            c = s / 10;
            res += s % 10 + '0';
            i++;
        }
        if(c != 0) {
            res += c + '0';
        }
        
        return res;
    }
    
    string multiply(string num1, string num2) {
        reverse(num1.begin(), num1.end());
        reverse(num2.begin(), num2.end());
        
        string ret;
        for(int i = 0;i < num2.size();++i) {
            string t = multiply_1digit(num1, num2[i] - '0');
            string s;
            for(int j = 1;j <= i;++j) {
                s += '0';
            }
            s += t;
            ret = add(ret, s);
        }
        int l = ret.size();
        while(l > 0 && ret[l - 1] == '0') l--;
        ret = ret.substr(0, l);
        reverse(ret.begin(), ret.end());
        
        if(ret.size() == 0) return "0";
        return ret;
    }
};