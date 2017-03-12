/**
 * Definition for a point.
 * struct Point {
 *     int x;
 *     int y;
 *     Point() : x(0), y(0) {}
 *     Point(int a, int b) : x(a), y(b) {}
 * };
 */
class Solution {
public:
    int maxPoints(vector<Point>& points) {
        int ret = 0;
        int n = points.size();
        if(n <= 2) return n;
        
        for(int i = 0;i < n;++i) {
            int dup = 1;
            unordered_map<int, int> hash_table;
            for(int j = 0;j < n;++j) {
                if(i == j) continue;
                if(points[i].x == points[j].x) {
                    if(points[i].y == points[j].y) dup++;
                    else {
                        hash_table[INT_MAX]++;
                    }
                } else {
                    hash_table[1000000* (points[i].y - points[j].y) / (points[i].x - points[j].x)]++;
                }
            }
            int max_p = 0;
            for(unordered_map<int, int>::const_iterator it = hash_table.begin(); 
                   it != hash_table.end();++it) {
                max_p = max(max_p, it->second);
            }
            ret = max(ret, max_p + dup);
        }
        
        return ret;
    }
};