class ValidWordAbbr {
public:
    unordered_map<string, set<string> > abb_words;
    
    string get_abb(const string& word) {
        if(word.size() <= 2) return word;
        char chr[10];
        sprintf(chr, "%c%d%c", word[0], int(word.size() - 2), word.back());
        return string(chr);
    }
    
    ValidWordAbbr(vector<string> &dictionary) {
        for(size_t i = 0;i < dictionary.size();++i) {
            abb_words[get_abb(dictionary[i])].insert(dictionary[i]);
        }
    }

    bool isUnique(string word) {
        string ab = get_abb(word);
        unordered_map<string, set<string> >::iterator it = abb_words.find(ab);
        if(it == abb_words.end()) {
            return true;
        }
        
        if(it->second.size() > 1) {
            return false;
        }
        
        if(it->second.size() == 1 && *(it->second.begin()) == word) {
            return true;
        }
        
        return false;
    }
};


// Your ValidWordAbbr object will be instantiated and called as such:
// ValidWordAbbr vwa(dictionary);
// vwa.isUnique("hello");
// vwa.isUnique("anotherWord");