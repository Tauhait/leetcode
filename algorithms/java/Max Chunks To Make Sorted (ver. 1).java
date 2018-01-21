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
        Collections.sort(intervals);
        List<Interval> newIntervals = new ArrayList<>();
        int s = intervals.get(0).s, e = intervals.get(0).e;
        for (int i = 1; i < intervals.size(); ++i) {
            if (intervals.get(i).s > e) {
                newIntervals.add(new Interval(s, e));
                s = intervals.get(i).s;
                e = intervals.get(i).e;
            } else {
                e = Math.max(e, intervals.get(i).e);
            }
        }
        newIntervals.add(new Interval(s, e));
        return newIntervals;
    }

    public int maxChunksToSorted(int[] arr) {
        int n = arr.length;
        if (n == 0) return 0;
        List<Interval> intervals = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            int s = Math.min(i, arr[i]);
            int e = Math.max(i, arr[i]);
            intervals.add(new Interval(s, e));
        }
        intervals = mergeIntervals(intervals);
        return intervals.size();
    }
}