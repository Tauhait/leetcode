public class Solution {
    private class Pair implements Comparable<Pair> {
        public Pair(int _val, String _rep) {
            val = _val;
            rep = _rep;
        }
        
        private int val;
        private String rep;
        
        public int compareTo(Pair that) {
            return that.val - this.val;
        }
    }

    public String findContestMatch(int n) {
        Pair[] pairs = new Pair[n];
        for(int i = 1;i <= n;++i) {
            pairs[i - 1] = new Pair(n - i + 1, String.valueOf(n - i + 1));  
        }
        
        while(pairs.length > 1) {
            n = pairs.length;
            int m = n / 2;
            Pair[] npairs = new Pair[m];
            for(int i = 0;i < m;++i) {
                int val = pairs[i].val;
                StringBuilder rep = new StringBuilder();
                if(pairs[i].rep.indexOf("(") == -1) {
                    rep.append("(");
                    rep.append(pairs[n - i - 1].rep);
                    rep.append(",");
                    rep.append(pairs[i].rep);
                    rep.append(")");
                    npairs[i] = new Pair(val, rep.toString());
                    
                } else {
                    rep.append("(");
                    rep.append(pairs[i].rep);
                    rep.append(",");
                    rep.append(pairs[n - i - 1].rep);
                    rep.append(")");
                    npairs[i] = new Pair(val, rep.toString());
                }
            }
            Arrays.sort(npairs);
            pairs = npairs;
        }
        
        return pairs[0].rep;
    }
}