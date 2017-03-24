public class Solution {
    public List<List<Integer> > fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer> > res = new ArrayList<>();
        for(int i = 0;i < n;++i) {
            while(i != 0 && i < n && nums[i] == nums[i - 1]) i++;
            if(i == n) break;
            
            for(int j = i + 1;j < n;++j) {
                while(j != i + 1 && j < n && nums[j] == nums[j - 1]) j++;
                if(j == n) break;
               
                int t = target - nums[i] - nums[j];
                int p = j + 1, q = n - 1;
                while(p < q) {
                    if(nums[p] + nums[q] == t) {
                        res.add(Arrays.asList(nums[i], nums[j], nums[p], nums[q]));
                        p++;
                        q--;
                        while(p < n && nums[p] == nums[p - 1]) p++;
                        while(q >= 0 && nums[q] == nums[q + 1]) q--;
                    } else if(nums[p] + nums[q] < t) {
                        p++;
                    } else {
                        q--;  
                    }
                }
            }
        }
        
        return res;
    }
}