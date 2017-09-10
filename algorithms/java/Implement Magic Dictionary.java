class MagicDictionary {
    Set<String> set;
    
    /** Initialize your data structure here. */
    public MagicDictionary() {
        set = new HashSet<>();
    }
    
    /** Build a dictionary through a list of words */
    public void buildDict(String[] dict) {
        for(int i = 0;i < dict.length;++i) {
            set.add(dict[i]);
        }
    }
    
    /** Returns if there is any word in the trie that equals to the given word after modifying exactly one character */
    public boolean search(String word) {
        char[] chr = word.toCharArray();
        for(int i = 0;i < word.length();++i) {
            for(char j = 'a';j <= 'z';++j) {
                if(chr[i] == j) continue;
                chr[i] = j;
                String s = new String(chr);
                if(set.contains(s)) return true;
                chr[i] = word.charAt(i);
            }
        }
        return false;
    }
}

/**
 * Your MagicDictionary object will be instantiated and called as such:
 * MagicDictionary obj = new MagicDictionary();
 * obj.buildDict(dict);
 * boolean param_2 = obj.search(word);
 */