class Solution {
    private static class Interval implements Comparable<Interval> {
        int s;
        int e;
        public Interval(int s, int e) {
            this.s = s;
            this.e = e;
        }
        public int compareTo(Interval that) {
            return this.s - that.s;
        }
    }
    
    public List<Integer> partitionLabels(String S) {
        Map<Character, Interval> map = new HashMap<>();
        for(int i = 0;i < S.length();++i) {
            char c = S.charAt(i);
            map.putIfAbsent(c, new Interval(S.length(), -1));
            map.get(c).s = Math.min(map.get(c).s, i);
            map.get(c).e = Math.max(map.get(c).e, i);
        }
    
        List<Interval> list = new ArrayList<>();
        for(Map.Entry<Character, Interval> entry : map.entrySet())
            list.add(entry.getValue());
        Collections.sort(list);
        List<Integer> ret = new ArrayList<>();
        if(list.size() == 1) ret.add(S.length());
        else {
            int s = list.get(0).s, e = list.get(0).e;
            for(int i = 1;i < list.size();++i) {
                if(list.get(i).s > e) {
                    ret.add(e - s + 1);
                    s = list.get(i).s;
                    e = list.get(i).e;
                } else {
                    e = Math.max(e, list.get(i).e);
                }
            }
            ret.add(e - s + 1);
        }
        return ret;
    }
}