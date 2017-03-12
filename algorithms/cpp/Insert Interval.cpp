/**
 * Definition for an interval.
 * struct Interval {
 *     int start;
 *     int end;
 *     Interval() : start(0), end(0) {}
 *     Interval(int s, int e) : start(s), end(e) {}
 * };
 */
class Solution {
public:
    vector<Interval> insert(vector<Interval>& intervals, Interval newInterval) {
        vector<Interval> ret;
        bool Isinsert = false;
        for(size_t i = 0;i < intervals.size();++i) {
            if(Isinsert) {
                ret.push_back(intervals[i]);
            } else {
                if(newInterval.end < intervals[i].start) {
                    ret.push_back(newInterval);
                    Isinsert = true;
                    ret.push_back(intervals[i]);
                } else if(newInterval.start > intervals[i].end) {
                    ret.push_back(intervals[i]);
                } else {
                    newInterval.start = min(newInterval.start, intervals[i].start);
                    newInterval.end = max(newInterval.end, intervals[i].end);
                }
            }
        }
        
        if(Isinsert == false) {
            ret.push_back(newInterval);
        }
        
        return ret;
    }
};