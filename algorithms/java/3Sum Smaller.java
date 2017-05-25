public class Solution {
    public int threeSumSmaller(int[] nums, int target) {
        int n = nums.length;
        if(n < 3) {
            return 0;
        }
        Arrays.sort(nums);
        int ret = 0;
        for(int i = 0;i < n;++i) {
            int j = i + 1;
            int k = n - 1;
            while(j < k) {
                int t = nums[i] + nums[j] + nums[k];
                if(t < target) {
                    ret += k - j;
                    j++;
                } else if(t >= target) {
                    k--;
                }
            }
        }
        
        return ret;
    }
}