class Solution {
public:
    string fractionToDecimal(int numerator, int denominator) {
        long long numerator1 = numerator;
        long long denominator1 = denominator;
        string ret;
        if(denominator1 == 0 || numerator1 == 0) return "0";
        if(numerator1 < 0 && denominator1 > 0) ret.push_back('-');
        if(numerator1 > 0 && denominator1 < 0) ret.push_back('-');
        
        if(numerator1 < 0) numerator1 = -numerator1;
        if(denominator1 < 0) denominator1 = -denominator1;
        
        ret += to_string(numerator1 / denominator1);
        long long num = numerator1 % denominator1;
        if(num != 0) {
            ret += ".";
        }
        unordered_map<int, int> hash_table;
        while(num != 0) {
            if(hash_table.find(num) != hash_table.end()) {
                ret.insert(hash_table[num], "(");
                ret.push_back(')');
                break;
            }
            hash_table.insert(make_pair(num, ret.size()));
            ret += to_string((num * 10) / denominator1);
            num = (num * 10) % denominator1;
        }
        
        return ret;
    }
};