public class Solution {
    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
    
    public int missingNumber(int[] nums) {
        int i = 0;
        while(i < nums.length) {
            if(i == nums[i]) i++;
            else if(nums[i] == nums.length) i++;
            else {
                swap(nums, i, nums[i]);    
            }
        }
        for(i = 0;i < nums.length;++i) {
            if(nums[i] != i) return i;
        }
        return nums.length;
    }
}