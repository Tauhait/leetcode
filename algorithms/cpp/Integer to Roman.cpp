class Solution {
public:
    string intToRoman(int num) {
        int n = num;
        string ret;
        // 1000
        while(n >= 1000) {
            ret += "M";
            n -= 1000;
        }
        if(n >= 900) {
            ret += "CM";
            n -= 900;
        }
        // 500
        if(n >= 500) {
            ret += "D";
            n -= 500;
        }
        if(n >= 400) {
            ret += "CD";
            n -= 400;
        }
        
        while(n >= 100) {
            ret += "C";
            n -= 100;
        }
        
        if(n >= 90) {
            ret += "XC";
            n -= 90;
        }
        
        if(n >= 50) {
            ret += "L";
            n -= 50;
        }
        if(n >= 40) {
            ret += "XL";
            n -= 40;
        }
        while(n >= 10) {
            ret += "X";
            n -= 10;
        }
        if(n >= 9) {
            ret += "IX";
            n -= 9;
        }
        if(n >= 5) {
            ret += "V";
            n -= 5;
        }
        if(n >= 4) {
            ret += "IV";
            n -= 4;
        }
        while(n >= 1) {
            ret += "I";
            n -= 1;
        }
        
        return ret;
    }
};