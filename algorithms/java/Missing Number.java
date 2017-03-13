public class Solution {
    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
    
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int i = 0;
        while(i < nums.length) {
            if(nums[i] >= n) {
                i++;
            } else {
                if(nums[i] != i) {
                    swap(nums, i, nums[i]);
                } else{
                    i++;
                }
            }
        }
        
        for(int j = 0;j < n;++j) {
            if(j != nums[j]) {
                return j;
            }
        }
        
        return n;
    }
}