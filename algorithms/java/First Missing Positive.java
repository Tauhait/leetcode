public class Solution {
    private void swap(int i, int j, int[] nums) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
    
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        
        int j = 0;
        while(j < n) {
            if(nums[j] > n || nums[j] <= 0) j++;
            else if(nums[j] == j + 1) j++;
            else if(nums[nums[j] - 1] == nums[j]) j++;
            else swap(nums[j] - 1, j, nums);
        }
        
        for(int i = 0;i < n;++i) {
            if(nums[i] != i + 1) return i + 1;
        }
        return n + 1;
    }
}