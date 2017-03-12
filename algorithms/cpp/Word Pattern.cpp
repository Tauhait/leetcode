class Solution {
public:
    bool wordPattern(string pattern, string str) {
        if(pattern.size() == 0) {
            if(str.size() == 0) return true;
            else return false;
        }
        size_t s = 0;
        vector<string> match(26, "");
        for(size_t i = 0;i < pattern.size();++i) {
            if(pattern[i] == ' ') return false;
            size_t j = s;
            while(j < str.size() && str[j] != ' '){
                //cout << str[j] << endl;
                j++;
            }
            //cout << "-----" << endl;
            if(j == s) return false;
            string word = str.substr(s, j - s);
            //cout << word << endl;
            if(match[pattern[i] - 'a'].size() == 0) {
                match[pattern[i] - 'a'] = word;
            } else {
                if(match[pattern[i] - 'a'] != word) return false;
            }
            s = j + 1;
        }
        
        for(int i = 0;i < 26;++i) {
            for(int j = i + 1;j < 26;++j) {
                if(match[i].size() == 0 || match[j].size() == 0) continue;
                //cout << i << " " << j << " " << match[i] << " " << match[j] << endl;  
                if(match[i] == match[j]) return false;
            }
        }
        
        return true;
    }
};