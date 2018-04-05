class Solution {
    private static class Pair {
        char c;
        int cnt;

        public Pair(char c, int cnt) {
            this.c = c;
            this.cnt = cnt;
        }
    }

    public int expressiveWords(String S, String[] words) {
        int count = 0;
        for (int i = 0; i < words.length; ++i) {
            if (stretchy(S, words[i])) count++;
        }
        return count;
    }

    private List<Pair> getPairs(String s) {
        List<Pair> pairs = new ArrayList<>();
        if (s.length() == 0) return pairs;
        int c = 1;
        for (int i = 1; i < s.length(); ++i) {
            if (s.charAt(i) != s.charAt(i - 1)) {
                pairs.add(new Pair(s.charAt(i - 1), c));
                c = 1;
            } else {
                c++;
            }
        }

        if (c != 0) {
            pairs.add(new Pair(s.charAt(s.length() - 1), c));
        }

        return pairs;
    }

    private boolean stretchy(String s, String word) {
        List<Pair> sPair = getPairs(s);
        List<Pair> wPair = getPairs(word);
        if (sPair.size() != wPair.size()) return false;
        for (int i = 0; i < sPair.size(); ++i) {
            if (sPair.get(i).cnt < wPair.get(i).cnt) return false;
            else if (sPair.get(i).cnt == wPair.get(i).cnt) continue;
            else if(sPair.get(i).cnt >= 3) continue;
            else if(sPair.get(i).cnt < 3) return false;
        }
        return true;
    }  
}
