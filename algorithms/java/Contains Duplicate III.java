public class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if(k == 0) return false;
        
        TreeSet<Long> set = new TreeSet<>();
        for(int i = 0;i < nums.length;++i) {
            if(i > k) {
                set.remove((long) nums[i - k - 1]);
            }
            Long ceil = set.ceiling((long)nums[i]);
            if(ceil != null && ceil.intValue() - (long)nums[i] <= t) {
                return true;
            }
            Long floor = set.floor((long)nums[i]);
            if(floor != null && (long)nums[i] - floor.intValue() <= t) {
                return true;
            }
            
            set.add((long)nums[i]); // don't forget this
        }
        
        return false;
    }
}