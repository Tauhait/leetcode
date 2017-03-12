class Solution {
public:
    unordered_map<string, int> mapBank;
    
    bool notUsed(const string& gene) {
        if(mapBank.find(gene) != mapBank.end() && mapBank[gene] == 0) {
            return true;
        }
        
        return false;
    }
    
    vector<string> candidates(const string& front, const int& pos) {
        vector<string> cands(3, front);
        switch(front[pos]) {
            case 'A':
                cands[0][pos] = 'C';
                cands[1][pos] = 'G';
                cands[2][pos] = 'T';
                break;
            case 'C':
                cands[0][pos] = 'A';
                cands[1][pos] = 'G';
                cands[2][pos] = 'T';
                break;
            case 'G':
                cands[0][pos] = 'C';
                cands[1][pos] = 'A';
                cands[2][pos] = 'T';
                break;
            case 'T':
                cands[0][pos] = 'C';
                cands[1][pos] = 'G';
                cands[2][pos] = 'A';
                break;
        }
        
        return cands;
    }
    
    int minMutation(string start, string end, vector<string>& bank) {
        if(start == end) return 0;
        
        for(int i = 0;i < bank.size();++i) {
            mapBank.insert(make_pair(bank[i], 0));
        }    
        
        if(!notUsed(end)) {
            return -1;
        }

        queue<string> q;
        q.push(start);
        if(mapBank.find(start) != mapBank.end()) {
            mapBank[start] = 1;
        }
        
        int mutations = 0;
        while(!q.empty()) {
            int s = q.size();
            mutations++;
            for(int i = 0;i < s;++i) {
                string front = q.front();
                q.pop();
                
                for(int j = 0;j < front.size();++j) {
                    vector<string> cands = candidates(front, j);
                    for(int k = 0;k < cands.size();++k) {
                        if(cands[k] == end) return mutations;
                        if(notUsed(cands[k])) {
                            q.push(cands[k]);
                            mapBank[cands[k]] = 1;
                        }
                    }
                }
            }
        }
        
        return -1;
    }
};