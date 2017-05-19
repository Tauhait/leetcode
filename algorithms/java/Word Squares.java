public class Solution {
    private class TrieNode {
        private List<Integer> words = new ArrayList<>();
        private TrieNode[] children = new TrieNode[26];
    }
    
    private class Trie {
        private TrieNode root = new TrieNode();
        
        private void insert(String word, int wordId) {
            TrieNode p = root;
            for(char c: word.toCharArray()) {
                if(p.children[c - 'a'] == null) {
                    p.children[c - 'a'] = new TrieNode();
                }
                p = p.children[c - 'a'];
            }
            p.words.add(wordId);
        }
        
        private void dfs(TrieNode root, List<Integer> validWords) {
            if(root == null) {
                return;
            }    
            if(root.words.size() != 0) {
                validWords.addAll(root.words);    
            }
            for(int i = 0;i < 26;++i) {
                if(root.children[i] != null) {
                    dfs(root.children[i], validWords);
                }
            }
        }
        
        private List<Integer> getPrefixWords(String prefix) {
            List<Integer> validWords = new ArrayList<>();
            TrieNode p = root;
            for(char c: prefix.toCharArray()) {
                if(p.children[c - 'a'] != null) {
                    p = p.children[c - 'a'];
                } else {
                    return validWords;
                }
            }
            dfs(p, validWords);
            return validWords;
        }
    }
    
    private List<List<String> > ret = new ArrayList<>();
    private Trie trie = new Trie();
    private int wordLength;
    private int numOfWords;
    
    private void dfs(int cur, int[] ans, String[] words) {
        if(wordLength == cur) {
            ArrayList<String> res = new ArrayList<>();
            for(int i = 0;i < wordLength;++i) {
                res.add(words[ans[i]]);
            }
            ret.add(res);
            return ;
        }
     
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i < cur;++i) {
            sb.append(words[ans[i]].charAt(cur));
        }
            
        List<Integer> validWords = trie.getPrefixWords(sb.toString());
        for(Integer id: validWords) {    
            ans[cur] = id;
            dfs(cur + 1, ans, words);
        }
    }
    
    public List<List<String>> wordSquares(String[] words) {
        numOfWords = words.length;
        if(numOfWords == 0) {
            return ret;
        }
        wordLength = words[0].length();
        for(int i = 0;i < numOfWords;++i) {
            trie.insert(words[i], i);
        }
        
        int[] ans = new int[wordLength];
        dfs(0, ans, words);
        
        return ret;
    }
}