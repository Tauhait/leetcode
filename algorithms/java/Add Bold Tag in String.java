class Solution {
    private static class Interval implements Comparable<Interval> {
        private int s;
        private int e;
        public Interval(int s, int e) {
            this.s = s;
            this.e = e;
        }
        public int compareTo(Interval that) {
            return this.s - that.s;
        }
    }
    
    private List<Interval> mergeIntervals(List<Interval> intervals) {
        if(intervals.size() == 0) return Collections.emptyList();
        Collections.sort(intervals);   
        List<Interval> merged = new ArrayList<>();
        int s = intervals.get(0).s, e = intervals.get(0).e;
        for(int i = 1;i < intervals.size();++i) {
            if(intervals.get(i).s <= e + 1) {
                e = Math.max(e, intervals.get(i).e);
            } else {
                merged.add(new Interval(s, e));
                s = intervals.get(i).s;
                e = intervals.get(i).e;
            }
        }
        merged.add(new Interval(s, e));
        return merged;
    }
    
    public String addBoldTag(String s, String[] dict) {
        List<Interval> intervals = new ArrayList<>();
        for(String word: dict) {
            int pos = s.indexOf(word);
            while(pos >= 0) {
                intervals.add(new Interval(pos, pos + word.length() - 1));
                pos = s.indexOf(word, pos + 1);
            }
        }
        if(intervals.size() == 0) return s;
        intervals = mergeIntervals(intervals);
        
        // print result
        StringBuilder sb = new StringBuilder();
        int start = 0;
        for(int i = 0;i < intervals.size();++i) {
            sb.append(s.substring(start, intervals.get(i).s));
            sb.append("<b>")
                .append(s.substring(intervals.get(i).s, intervals.get(i).e + 1))
                .append("</b>");
            start = intervals.get(i).e + 1;
        }
        sb.append(s.substring(start));
        return sb.toString();
    }
}