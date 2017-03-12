class Solution {
public:
    int rangeBitwiseAnd(int m, int n) {
        int r = m & n;
        std::bitset<32> mbit(m);
        std::bitset<32> nbit(n);
        std::bitset<32> rbit(r);
        
        int i = 31;
        for(i = 31;i >= 0;--i) {
            if(rbit[i] != 0) break;
            
            if(rbit[i] == 0 && nbit[i] != 0) return 0;
        }
        
        int f = 0;
        for(;i >= 0;--i) {
            if(f == 1) {
                rbit[i] = 0;
                continue;
            }
            
            if(mbit[i] == 0 && nbit[i] == 1) {
                f = 1;
                rbit[i] = 0;
                nbit[i] = 0;
                mbit[i] = 0;
            }
        }
        
        return rbit.to_ulong();
    }
};