public class Solution {
    public int[] findErrorNums(int[] nums) {
        int[] ret = new int[2];
        int[] count = new int[nums.length + 1];
        for(int i = 0;i < nums.length;++i) {
            count[nums[i]]++;
        }
        for(int i = 1;i <= nums.length;++i) {
            if(count[i] > 1) {
                ret[0] = i;
            }
            if(count[i] == 0) {
                ret[1] = i;
            }
        }
        return ret;       
    }
}