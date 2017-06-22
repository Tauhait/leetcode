public class Solution {
    public int smallestFactorization(int a) {
        if(a == 1) {
            return 1;
        }
        int[] nums = new int[32];
        int id = 0;
        for(int i = 9;i >= 2;--i) {
            while(a % i == 0) {
                nums[id] = i;
                id++;
                a /= i;
            }
        }
        if(a != 1) {
            return 0;
        }
        if(id > 10) {
            return 0;
        }
        long ans = 0;
        for(int i = id - 1;i >= 0;--i) {
            ans = ans * 10 + nums[i];
        }
        if(ans > Integer.MAX_VALUE) {
            return 0;
        }
        return (int) ans;
    }
}