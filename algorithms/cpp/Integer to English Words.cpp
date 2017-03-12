class Solution {
public:
    unordered_map<int, string> digit2char;
    string readIt(int num) {
        string res;
        if(num  / 100 > 0) {
            res += digit2char[num / 100];
            res += " Hundred";
        }
        num %= 100;
        
        if(num == 0) return res;
        
        if(num < 20) {
            if(res.size() != 0) res += ' ';
            res += digit2char[num];
            return res;
        }
        
        if(num  / 10 > 0) {
            if(res.size() != 0) res += ' ';
            res += digit2char[num - num % 10];    
        }
        
        num %= 10;
        if(num == 0) return res;
        
        if(res.size() != 0) res += ' ';
        res += digit2char[num];
        
        return res;
    }
    
    string numberToWords(int num) {
        if(num == 0) return "Zero";
        
        int billion = 1000000000;
        int million = 1000000;
        int thousand = 1000;
        
        digit2char[0] = "Zero";
        digit2char[1] = "One";
        digit2char[2] = "Two";
        digit2char[3] = "Three";
        digit2char[4] = "Four";
        digit2char[5] = "Five";
        digit2char[6] = "Six";
        digit2char[7] = "Seven";
        digit2char[8] = "Eight";
        digit2char[9] = "Nine";
        digit2char[10] = "Ten";
        digit2char[11] = "Eleven"; 
        digit2char[12] = "Twelve";
        digit2char[13] = "Thirteen"; 
        digit2char[14] = "Fourteen";
        digit2char[15] = "Fifteen";
        digit2char[16] = "Sixteen";
        digit2char[17] = "Seventeen";
        digit2char[18] = "Eighteen";
        digit2char[19] = "Nineteen";
        
        digit2char[20] = "Twenty";
        digit2char[30] = "Thirty";
        digit2char[40] = "Forty";
        digit2char[50] = "Fifty";
        digit2char[60] = "Sixty";
        digit2char[70] = "Seventy";
        digit2char[80] = "Eighty";
        digit2char[90] = "Ninety";
        
        string ret;
        
        if(num / billion > 0) {
            ret += readIt(num / billion);
            ret += " Billion";
        }
        num %= billion;
        
        if(num / million > 0) {
            if(ret.size() != 0) ret += ' ';
            ret += readIt(num / million);
            ret += " Million";
        }
        num %= million;
        
        if(num / thousand > 0) {
            if(ret.size() != 0) ret += ' ';
            ret += readIt(num / thousand);
            ret += " Thousand";
        }
        num %= thousand;
        
        if(num > 0) {
            if(ret.size() != 0) ret += ' ';
            ret += readIt(num);
        }
        
        return ret;
    }
};