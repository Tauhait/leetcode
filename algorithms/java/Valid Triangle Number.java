public class Solution {
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        if(n < 3) {
            return 0;
        }
        int ret = 0;
        for(int i = 0;i < n;++i) {
            for(int j = i + 1;j < n;++j) {
                int c = nums[i] + nums[j];
                int index = Arrays.binarySearch(nums, c);
                if(index >= 0) {
                    while(index >=0 && nums[index] == c) index--;
                    ret += Math.max(0, index - (j + 1) + 1);
                } else {
                    index = -(index + 1);
                    index = Math.min(n - 1, index);
                    while(index >= 0 && nums[index] >= c) index--;
                    ret += Math.max(0, index - (j + 1) + 1);
                }
            }
        }
        return ret;
    }
}