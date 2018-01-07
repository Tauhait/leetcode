/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class Solution {
    private List<Interval> mergeIntervals(List<Interval> intervals) {
		Collections.sort(intervals, (a, b) -> a.start - b.start);
		List<Interval> newIntervals = new ArrayList<>();
		int s = intervals.get(0).start, e = intervals.get(0).end;
		for (int i = 1; i < intervals.size(); ++i) {
			if (intervals.get(i).start > e) {
				newIntervals.add(new Interval(s, e));
				s = intervals.get(i).start;
				e = intervals.get(i).end;
			} else {
				e = Math.max(e, intervals.get(i).end);
			}
		}
		newIntervals.add(new Interval(s, e));
		return newIntervals;
	}
    
    public List<Interval> employeeFreeTime(List<List<Interval>> avails) {
        List<Interval> intervals = new ArrayList<>();
        for(int i = 0;i < avails.size();++i) intervals.addAll(avails.get(i));
        intervals = mergeIntervals(intervals);
        List<Interval> ret = new ArrayList<>();
        if(intervals.size() == 1) return ret;
        for(int i = 1;i < intervals.size();++i)
            ret.add(new Interval(intervals.get(i - 1).end, intervals.get(i).start));
        return ret;
    }
}