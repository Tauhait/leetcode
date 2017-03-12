class Solution {
public:
    int nthUglyNumber(int n) {
        int i2 = 0, i3 = 0, i5 = 0;
	    vector<int> res;
	    res.push_back(1);
	    for(int i = 2;i <= n;++i) {
	        int m2 = res[i2] * 2;
	        int m3 = res[i3] * 3;
	        int m5 = res[i5] * 5;

	        int m = min(m2, min(m3, m5));
	        res.push_back(m);
	        if(m == m2) i2++;
	        if(m == m3) i3++;
	        if(m == m5) i5++;
	    }
        
        return res[n - 1];
    }
};