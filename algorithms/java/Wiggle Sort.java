public class Solution {
    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
    public void wiggleSort(int[] nums) {
        for(int i = 0;i < nums.length - 1;++i) {
            if((i % 2 == 0 && nums[i] > nums[i + 1]) || (i % 2 == 1 && nums[i] < nums[i + 1]))
                swap(nums, i, i + 1);
        }
    }
}