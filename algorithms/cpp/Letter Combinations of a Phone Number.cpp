class Solution {
public:
    vector<string> res;
    unordered_map<char, string> dig_letters;
    
    void dfs(const string& digits, const size_t& index, const string& cur) {
        if(index == digits.size()) {
            res.push_back(cur);
            return ;
        }
        
        for(size_t i = 0;i < dig_letters[digits[index]].size();++i) {
            dfs(digits, index + 1, cur + dig_letters[digits[index]][i]);
        }
    }
    
    vector<string> letterCombinations(string digits) {
        if(digits.size() == 0) return res;
        
        dig_letters['2'] = "abc";
        dig_letters['3'] = "def";
        dig_letters['4'] = "ghi";
        dig_letters['5'] = "jkl";
        dig_letters['6'] = "mno";
        dig_letters['7'] = "pqrs";
        dig_letters['8'] = "tuv";
        dig_letters['9'] = "wxyz";
        
        string cur;
        dfs(digits, 0, cur);
            
        return res;
    }
};