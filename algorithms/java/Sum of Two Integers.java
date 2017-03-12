public class Solution {
    public int getSum(int a, int b) {
        int c = 0;
        int res = 0;
        for(int i = 0;i < 32;++i) {
            int bit = 1 << i;
            int ab = (a & bit) >>> i;
            int bb = (b & bit) >>> i;
            
            
            
            res |= (c ^ ab ^ bb) << i;
            if(c == 1 && ab == 1) c = 1;
            else if(c == 1 && bb == 1) c = 1;
            else if(ab == 1 && bb == 1) c = 1;
            else c = 0;
        }
        
        return res;
    }
}