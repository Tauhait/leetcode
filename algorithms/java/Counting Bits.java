public class Solution {
    public int[] countBits(int num) {
        if(num == 0) return new int[]{0};
        if(num == 1) return new int[]{0, 1};
        if(num == 2) return new int[]{0, 1, 1};
        
        int[] res = new int[num + 1];
        res[0] = 0;
        res[1] = 1;
        res[2] = 1;
        
        int v = 2;
        for(int i = 3;i <= num;++i) {
            if(i == v * 2) {
                v = v * 2;
            }
            
            res[i] = 1 + res[i - v];
        }
        
        return res;
    }
}