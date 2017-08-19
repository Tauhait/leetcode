public class Solution {
    private int robI(int[] nums) {
        if(nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        if(nums.length == 2) return Math.max(nums[0], nums[1]);
        
        int[] opt = new int[nums.length];
        opt[0] = nums[0];
        opt[1] = Math.max(nums[0], nums[1]);
        for(int i = 2;i < nums.length;++i) {
            opt[i] = Math.max(nums[i] + opt[i - 2], opt[i - 1]);
        }
        
        return opt[nums.length - 1];
    }
    
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 0) return 0;
        if(n == 1) return nums[0];
        
        int[] newArray1 = Arrays.copyOf(nums, n - 1);
        int[] newArray2 = Arrays.copyOfRange(nums, 1, n);
        return Math.max(robI(newArray1), robI(newArray2));
    }
}
////////////////////////////////////////////
public class Solution {
    private int robI(int[] nums, int l, int r) {
        int n = r - l + 1;
        if(n == 0) return 0;
        if(n == 1) return nums[l];
        if(n == 2) return Math.max(nums[l], nums[l + 1]);
        
        int[] opt = new int[n];
        opt[0] = nums[l];
        opt[1] = Math.max(nums[l], nums[l + 1]);
        for(int i = 2;i < n;++i) {
            opt[i] = Math.max(nums[l + i] + opt[i - 2], opt[i - 1]);
        }
        return opt[n - 1];
    }
    
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 0) return 0;
        if(n == 1) return nums[0];
        
        return Math.max(robI(nums, 0, n - 2), robI(nums, 1, n - 1));
    }
}