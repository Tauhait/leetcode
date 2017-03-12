class Solution {
public:
    int shortestDistance(vector<string>& words, string word1, string word2) {
        int index1 = -1, index2 = -1, ret = INT_MAX; 
        for(int i = 0;i < words.size();++i) {
            if(words[i] == word1) {
                if(index2 >= 0) {
                    ret = min(ret, i - index2);
                }
                index1 = i;
            }
            if(words[i] == word2) {
                if(index1 >= 0) {
                    ret = min(ret, i - index1);
                }
                index2 = i;
            }
        }
        
        return ret;
    }
    
    int shortestWordDistance(vector<string>& words, string word1, string word2) {
        if(word1 != word2) return shortestDistance(words, word1, word2);
        
        int index = -1, ret = INT_MAX; 
        for(int i = 0;i < words.size();++i) {
            if(words[i] == word1) {
                if(index >= 0) {
                    ret = min(ret, i - index);
                }
                index = i;
            }
        }
        
        return ret;
        
    }
};