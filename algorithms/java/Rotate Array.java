public class Solution {
    private void reverse(int[] nums, int l, int r) {
        while(l < r) {
            int tmp = nums[l];
            nums[l] = nums[r];
            nums[r] = tmp;
            l++;
            r--;
        }
    }
    
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        if(n == 0 || n == 1 || k == 0){
            return;
        }
        k = k % n;
        
        reverse(nums, 0, n - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, n - 1);
    }
}