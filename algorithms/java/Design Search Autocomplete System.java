public class AutocompleteSystem {
    private class PQNode implements Comparable<PQNode> {
        private int count;
        private String word;

        public PQNode(int count, String word) {
            this.count = count;
            this.word = word;
        }

        public int compareTo(PQNode that) {
            if (this.count == that.count) {
                return this.word.compareTo(that.word);
            }
            return that.count - this.count;
        }
    }

    private class TrieNode {
        private int count;
        private String word;
        private boolean isWord;

        private Map<Character, TrieNode> children; 

        public TrieNode() {
            count = 0;
            isWord = false;
            children = new HashMap<>();
        }
    }

    private class Trie {
        private TrieNode root;
        private TrieNode preNode;
        private StringBuilder wordBuffer;

        public Trie() {
            root = new TrieNode();
            preNode = root;
            wordBuffer = new StringBuilder();
        }

        public void insertWord(String word, int count) {
            TrieNode p = root;
            for (char c : word.toCharArray()) {
                p.children.putIfAbsent(c, new TrieNode());
                p = p.children.get(c);
            }
            p.count = count;
            p.isWord = true;
            p.word = word;
        }

        private void dfs(TrieNode p, PriorityQueue<PQNode> pq) {
            if (p == null) {
                return;
            }

            if (p.isWord) {
                pq.add(new PQNode(p.count, p.word));
            }
            
            for (Map.Entry<Character, TrieNode> entry : p.children.entrySet()) {
                dfs(entry.getValue(), pq);
            }
        }

        public List<String> search(char c) {
            if (c == '#') {
                if (preNode == null) {
                    throw new RuntimeException("Something wrong");
                }

                preNode.count++;
                preNode.isWord = true;
                preNode.word = wordBuffer.toString();
                
                wordBuffer = new StringBuilder();
                preNode = root;
                return Collections.emptyList();
            }

            wordBuffer.append(c);
            if (!preNode.children.containsKey(c)) {
                preNode.children.putIfAbsent(c, new TrieNode());
                preNode = preNode.children.get(c);
                return Collections.emptyList();
            }

            
            preNode = preNode.children.get(c);

            PriorityQueue<PQNode> pq = new PriorityQueue<>();
            TrieNode p = preNode;
            dfs(p, pq);
            List<String> matches = new ArrayList<>();
            int index = 0;
            while (!pq.isEmpty() && index < 3) {
                matches.add(pq.poll().word);
                index++;
            }
            return matches;
        }
    }

    Trie trie = new Trie();

    public AutocompleteSystem(String[] sentences, int[] times) {
        for (int i = 0; i < sentences.length; ++i) {
            trie.insertWord(sentences[i], times[i]);
        }
    }

    public List<String> input(char c) {
        return trie.search(c);
    }
}

/**
 * Your AutocompleteSystem object will be instantiated and called as such:
 * AutocompleteSystem obj = new AutocompleteSystem(sentences, times);
 * List<String> param_1 = obj.input(c);
 */