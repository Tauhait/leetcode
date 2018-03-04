class Solution {
    public int numMatchingSubseq(String S, String[] words) {
        Map<Character, TreeSet<Integer> > map = new HashMap<>();
        for(int i = 0;i < S.length();++i) {
            char c = S.charAt(i);
            map.putIfAbsent(c, new TreeSet<>());
            map.get(c).add(i);
        }
        int count = 0;
        for(int i = 0;i < words.length;++i) {
            int pos = 0;
            boolean f = true;
            for(int j = 0;j < words[i].length();++j) {
                char c = words[i].charAt(j);
                if(!map.containsKey(c)) {f = false;break;}
                TreeSet<Integer> set = map.get(c);
                Integer p = set.ceiling(pos);
                if(p == null) {f = false;break;}
                pos = p.intValue() + 1;
            }
            if(f) count++;
        }
        return count;
    }
}