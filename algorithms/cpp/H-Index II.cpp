class Solution {
public:
    int hIndex(vector<int>& citations) {
        int n = citations.size();
        
        int l = 0, h = n - 1;
        while(l <= h) {
            int m = (l + h) / 2;
            if(n - m > citations[m]) {
                l = m + 1;
            } else if(n - m < citations[m]) {
                h = m - 1;
            }
            else {
                return n - m;
            }
        }
        
        return n - l;
    }
};