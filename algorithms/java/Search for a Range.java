public class Solution {
    int left(int[] nums, int target) {
        // return the leftmost index whose value is target, or -1
        int l = 0, h = nums.length - 1;
        while(l < h) {
            int m = l + (h - l) / 2;
            if(nums[m] == target) {
                h = m;
            } else if(nums[m] > target) {
                h = m - 1;
            } else {
                l = m + 1;
            }
        }

        if(l >= 0 && l < nums.length && nums[l] == target) {
            return l;
        }
        return -1;
    }
    
    int right(int[] nums, int target) {
        // return the right most index whose value is target, or -1
        int l = 0, h = nums.length - 1;
        while(l < h) {
            int m = l + (h - l + 1) / 2;
            if(nums[m] == target) {
                l = m;
            } else if(nums[m] > target) {
                h = m - 1;
            } else {
                l = m + 1;
            }
        } 
        if(l >= 0 && l < nums.length && nums[l] == target) {
            return l;
        }
        return -1;
    }
    
    
    public int[] searchRange(int[] nums, int target) {
        return new int[]{left(nums, target), right(nums, target)};
    }
}