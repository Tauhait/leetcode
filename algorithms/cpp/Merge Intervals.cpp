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
    static bool cmp(const Interval& a, const Interval& b) {
        return a.start < b.start;    
    }
    
    vector<Interval> merge(vector<Interval>& intervals) {
        sort(intervals.begin(), intervals.end(), cmp);
        
        vector<Interval> ret;
        if(intervals.size() == 0) {
            return ret;
        }
        
        Interval cur = intervals[0];
        for(size_t i = 0;i < intervals.size();++i) {
            if(intervals[i].start > cur.end) {
                ret.push_back(cur);
                cur = intervals[i];
            } else {
                cur.end = max(intervals[i].end, cur.end);
            }
        }
        ret.push_back(cur);
        
        return ret;
    }
};