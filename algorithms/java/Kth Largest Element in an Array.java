class Solution {
    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
    
    private int kthSmallest(int[] nums, int low, int high, int k) {
        int pivot = low;
        int l = low, h = high;
        while(l < h) {
            while(l <= high && nums[l] <= nums[pivot]) l++;
            while(h >= low && nums[h] > nums[pivot]) h--;
            if(l < h) swap(nums, l, h);
        }
        swap(nums, pivot, h);
        if(h == k) return nums[h];
        else if(k > h) return kthSmallest(nums, h + 1, high, k);
        else return kthSmallest(nums, low, h - 1, k);
    }
    
    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        k = n - k;
        return kthSmallest(nums, 0, n - 1, k); 
    }
}