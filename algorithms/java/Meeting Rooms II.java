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
    private class Pair implements Comparable<Pair> {
        public Pair(int _time, int _sOrE) {
            time = _time;
            sOrE= _sOrE;
        }
        
        public int compareTo(Pair that) {
            if(this.time == that.time) {
                return this.sOrE - that.sOrE;
            }
            
            return this.time - that.time;
        }
        
        int time;
        int sOrE; // 1 start, -1 end
    }
    
    public int minMeetingRooms(Interval[] intervals) {
        int n = intervals.length;
        Pair[] times = new Pair[2 * n];
        for(int i = 0;i < n;++i) {
            times[2 * i] = new Pair(intervals[i].start, 1);
            times[2 * i + 1] = new Pair(intervals[i].end, -1);
        }
        
        Arrays.sort(times);
        int numRooms = 0;
        int res = 0;
        for(int i = 0;i < 2 * n;++i) {
            if(times[i].sOrE == 1) {
                numRooms++;
            } else {
                numRooms--;
            }
            res = Math.max(res, numRooms);//don't forget this
        }
        
        return res;
    }
}