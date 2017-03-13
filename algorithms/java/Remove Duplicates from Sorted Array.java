public class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length == 0) return 0;
        int len = 1;
        int i = 1;
        while(i < nums.length) {
            if(nums[i] != nums[i - 1]) {
                nums[len] = nums[i];
                len++;
            }
            i++;
        }
        
        return len;
    }
}