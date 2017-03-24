public class Solution {
	public List<String> wordsAbbreviation(List<String> dict) {
	    HashMap<String, List<String> > map = new HashMap<>();
	    HashMap<String, Trie> word_trie_map = new HashMap<>();
	    for(String word: dict) {
	        if(word.length() <= 3) {
	            continue;
	        }
	        StringBuilder sb = new StringBuilder();
	        sb.append(word.charAt(0));
	        sb.append(String.valueOf(word.length() - 2));
	        sb.append(word.charAt(word.length() - 1));
	        String key = sb.toString();
	        if(map.containsKey(key)) {
	            map.get(key).add(word);
	        } else {
	            map.put(key, new ArrayList<>());
	            map.get(key).add(word);
	        }
	    }
	    
	    for(Map.Entry<String, List<String> > entry: map.entrySet()) {
	        Trie trie = new Trie();
	        for(String word: entry.getValue()) {
	            word_trie_map.put(word, trie);
	            trie.insert(word);
	        }
	    }
	    
		List<String> res = new ArrayList<>();
		for(String word: dict) {
		    if(word.length() <= 3) {
		        res.add(word);
		    } else {
		        Trie trie = word_trie_map.get(word);
    		    res.add(trie.abbreviate(word));
		    }
		}
		
		return res;
	}
}

class Trie {
    public class TrieNode {
        public TrieNode() {
            count = 0;
        }
        
        int count;
        HashMap<Character, TrieNode> map = new HashMap<>();
    }
    
    TrieNode root = new TrieNode();
    
    public void insert(String word) {
        TrieNode p = root;
        for(int i = 0;i < word.length();++i) {
            char c = word.charAt(i);
            if(p.map.containsKey(c)) {
                p = p.map.get(c);
                p.count++;
            } else {
                TrieNode node = new TrieNode();
                p.map.put(c, node);
                p = node;
                p.count++;
            }
        }
    }
    
    public String abbreviate(String word) {
        TrieNode p = root.map.get(word.charAt(0));
        int index = 0;
        while(p.count > 1 && index < word.length()) {
            index++;
            p = p.map.get(word.charAt(index));
        }
        StringBuilder sb = new StringBuilder();
        sb.append(word.substring(0, index + 1));
        sb.append(String.valueOf(word.length() -(index + 2)));
        sb.append(word.charAt(word.length() - 1));
        
        String abbrev = sb.toString();
        if(abbrev.length() >= word.length()) {
            return word;
        } else {
            return abbrev;
        }
    }
}