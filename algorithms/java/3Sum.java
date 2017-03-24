public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer> > res = new ArrayList<>();
        int n = nums.length;
        for(int i = 0;i < n;++i) {
            while(i != 0 && i < n && nums[i] == nums[i - 1]) {
                i++;
            }
            if(i == n) break;
            
            int target = -nums[i];
            int j = i + 1, k = n - 1;
            while(j < k) {
                if(nums[j] + nums[k] == target) {
                    res.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    while(j < n && nums[j] == nums[j - 1]) j++;
                    k--;
                    while(k >= 0 && nums[k] == nums[k + 1]) k--;
                } else if(nums[j] + nums[k] > target) {
                    k--;
                }
                else {
                    j++;
                }
            }
        }
        
        return res;
    }
}