class Solution {
    private static final Random rand = new Random(); 
    private int[] nums;
    private int n;
    public Solution(int[] nums) {
        this.nums = nums;
        n = nums.length;
    }
    
    public int pick(int target) {
        int id = 1;
        int ret = -1;
        for(int i = 0;i < n;++i) {
            if(nums[i] == target) {
                if(id - 1 == rand.nextInt(id)) ret = i;
                id++;
            }
        }
        return ret;
    }
}
/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */