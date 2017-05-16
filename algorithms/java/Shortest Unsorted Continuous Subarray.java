public class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int n = nums.length;
        if(n == 0 || n == 1) {
            return 0;
        }
        
        int[] copy = Arrays.copyOf(nums, n);
        Arrays.sort(copy);
        int i = 0;
        while(i < n && copy[i] == nums[i]) i++;
        int j = n - 1;
        while(j >= 0 && copy[j] == nums[j]) j--;
        
        if(j - i + 1 > 0) {
            return j - i + 1;
        }
        return 0;
    }
}