class Solution {
public:
    bool isStrobogrammatic(string num) {
        if(num.find('2') != string::npos ||
           num.find('4') != string::npos ||
           num.find('5') != string::npos ||
           num.find('3') != string::npos ||
           num.find('7') != string::npos) return false;
         
         string str;
         for(size_t i = 0;i < num.size();++i) {
             if(num[i] == '6') {
                 str += '9';
             } else if(num[i] == '9') {
                 str += '6';
             } else {
                 str += num[i];
             }
         }
         reverse(str.begin(), str.end());
        if(num == str) return true;
        
        return false;
    }
};