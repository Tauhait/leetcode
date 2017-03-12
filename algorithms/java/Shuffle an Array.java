public class Solution {
    private int[] org_;
    private int[] nums_;
    
    public Solution(int[] nums) {
        nums_ = new int[nums.length];
        org_ = new int[nums.length];
        for(int i = 0;i < nums.length;++i) {
            nums_[i] = nums[i];
            org_[i] = nums[i];
        }
    }
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        for(int i = 0;i < nums_.length;++i) {
            nums_[i] = org_[i];
        }
        return nums_;
    }
    
    private void swap(int i, int j) {
        int tmp = nums_[i];
        nums_[i] = nums_[j];
        nums_[j] = tmp;
    }
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        Random rand = new Random();
        for(int i = 0;i < nums_.length;++i) {
            int r = rand.nextInt(nums_.length);
            swap(i, r);
        }
        return nums_;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */