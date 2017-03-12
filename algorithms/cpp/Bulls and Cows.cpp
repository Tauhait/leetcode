class Solution {
public:
    string getHint(string secret, string guess) {
        vector<int> count(10, 0);
        for(size_t i = 0;i < secret.size();++i) {
            count[secret[i] - '0']++;
        }
        int A = 0, B = 0;
        for(size_t i = 0;i < guess.size();++i) {
            if(secret[i] == guess[i]) {
                A++;
                count[guess[i] - '0']--;
            }
        }
        
        for(size_t i = 0;i < guess.size();++i) {
            if(secret[i] != guess[i]) {
                if(count[guess[i] - '0'] > 0) {
                    B++;
                    count[guess[i] - '0']--;
                }
            }
        }
        
        char hint[100];
        sprintf(hint, "%dA%dB", A, B);
        
        return string(hint);
    }
};