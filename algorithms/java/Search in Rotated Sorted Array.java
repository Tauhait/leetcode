public class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        if(n == 0) {
            return -1;
        }
        
        int l = 0, h = n - 1;
        while(l <= h) {
            int m = l + (h - l + 1) / 2;
            if(nums[m] == nums[l]) {
                if(target == nums[m]) {
                    return m;
                } else {
                    return -1;
                }
            } else if(nums[m] > nums[l]) {
                if(target == nums[m]) {
                    return m;
                } else if(target > nums[m]) {
                    l = m + 1;
                } else {
                    if(target >= nums[l]) {
                        h = m - 1;
                    } else {
                        l = m + 1;
                    }
                }
            } else {
                if(target == nums[m]) {
                    return m;
                } else if (target > nums[m]) {
                    if(target >= nums[l]) {
                        h = m - 1;
                    } else {
                        l = m + 1;
                    }
                } else {
                    h = m - 1;
                }
            }
        }
        return -1;
    }
}

////////////////////////////////////////////////////
public class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        if(n == 0) {
            return -1;
        }
        
        int l = 0, h = n - 1;
        while(l <= h) {
            int m = l + (h - l + 1) / 2;
            if(nums[m] == target) {
                return m;
            }
            
            if(nums[m] == nums[l]) { // l == h
                return -1;
            } else if(nums[m] > nums[l]) {
                if(target >= nums[l] && target < nums[m]) { // l to m is ascending
                    h = m - 1;
                } else {
                    l = m + 1;
                }
            } else {
                if(target > nums[m] && target <= nums[h]) { // m to h is ascending
                    l = m + 1;
                } else {
                    h = m - 1;
                }
            }
        }
        return -1;
    }
}