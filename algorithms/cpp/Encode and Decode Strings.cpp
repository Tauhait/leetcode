class Codec {
public:

    // Encodes a list of strings to a single string.
    string encode(vector<string>& strs) {
        string ret;
        if(strs.size() == 0) return ret;
        
        for(int i = 0;i < strs.size();++i) {
            int len = strs[i].size();
            char chr[100];
            sprintf(chr, "%d$", len);
            ret += chr;
            ret += strs[i];
        }
        
        return ret;
    }

    // Decodes a single string to a list of strings.
    vector<string> decode(string s) {
        vector<string> ret;
        if(s.size() == 0) {
            return ret;
        }
        
        size_t p = s.find_first_of('$');
        while(p != string::npos) {
            int len;
            sscanf(s.substr(0, p).c_str(), "%d", &len);
            ret.push_back(s.substr(p + 1, len));
            s = s.substr(p + 1 + len);
            
            p = s.find_first_of('$');
        }
        
        return ret;
    }
};

// Your Codec object will be instantiated and called as such:
// Codec codec;
// codec.decode(codec.encode(strs));