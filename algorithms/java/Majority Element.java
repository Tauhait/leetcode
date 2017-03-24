public class Solution {
    public int majorityElement(int[] nums) {
        /**
         * nlog(n)
        Arrays.sort(nums);
        int n = nums.length;
        return nums[n / 2];
        */
        /**
         * O(n)
         */
         int count = 0;
         int majority = -1;
         for(int i = 0;i < nums.length;++i) {
             if(count == 0) {
                 count = 1;
                 majority = nums[i];
             } else {
                 if(nums[i] == majority) {
                     count++;
                 } else {
                     count--;
                 }
             }
         }
         return majority;
    }
}