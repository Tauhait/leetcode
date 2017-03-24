/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public class CompInterval implements Comparator<Interval> {
        @Override
        public int compare(Interval a, Interval b) {
            return a.start - b.start;
        }
    }
    
    public boolean canAttendMeetings(Interval[] intervals) {
        int n = intervals.length;
        if(n < 2) {
            return true;
        }
        
        Arrays.sort(intervals, new CompInterval());
        for(int i = 1;i < n;++i) {
            if(intervals[i].start < intervals[i - 1].end) {
                return false;
            }
        }
        return true;
    }
}