class Solution {
public:
    int base(const char& c) {
        switch(c) {
            case 'A': return 0;
            case 'C': return 1;
            case 'G': return 2;
            case 'T': return 3;
        }
    }
    string decode(const uint32_t& hash_value) {
        string ret;
        uint32_t val = hash_value;
        for(int i = 0;i < 10;++i) {
            int c = val & 0x3;
            switch(c) {
                case 0: ret += 'A'; break;
                case 1: ret += 'C'; break;
                case 2: ret += 'G'; break;
                case 3: ret += 'T'; break;
            }
            val >>= 2;
        }
        
        reverse(ret.begin(), ret.end());
        return ret;
    }
    uint32_t getHashValue(const char* nucleotide) {
        uint32_t hash_value = 0;
        for(int i = 0;i < 10;++i) {
            hash_value <<= 2;
            hash_value += base(nucleotide[i]);
        }
        
        return hash_value;
    }
    
    vector<string> findRepeatedDnaSequences(string s) {
        unordered_map<uint32_t, int> hash_table;
        vector<string> ret;
        if(s.size() <= 10) return ret;
        for(int i = 0;i <= s.size() - 10;++i) {
            hash_table[getHashValue(s.substr(i, 10).c_str())]++;
        }
        
        for(auto& x : hash_table) {
            if(x.second > 1) {
                ret.push_back(decode(x.first));
            }
        }
        
        return ret;
    }
};