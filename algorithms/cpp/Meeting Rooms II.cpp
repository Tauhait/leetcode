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
    static bool cmp(const pair<int, int>& a, const pair<int, int>& b) {
        if(a.first == b.first) {
            return a.second < b.second;
        }    
        return a.first < b.first;
    }
    
    int minMeetingRooms(vector<Interval>& intervals) {
        vector<pair<int, int> > positions(2 * intervals.size());
        for(size_t i = 0;i < intervals.size();++i) {
            positions[i * 2] = make_pair(intervals[i].start, 1);
            positions[i * 2 + 1] = make_pair(intervals[i].end, -1);
        }
        sort(positions.begin(), positions.end(), cmp);
        
        int count = 0, ret = 0;
        for(size_t i = 0;i < intervals.size() * 2;++i) {
            if(positions[i].second == 1) {
                count++;
                ret = max(count, ret);
            } else {
                count--;
            }
        }
        
        return ret;
    }
};