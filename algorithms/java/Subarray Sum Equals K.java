public class Solution {
    HashMap<Integer, Integer> map = new HashMap<>();
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        if(n == 0) {
            return 0;
        }
        if(n == 1) {
            if(nums[0] == k) {
                return 1;
            } else {
                return 0;
            }
        }
        
        int ret = 0;
        int sum = 0;
        map.put(0, 1);
        for(int i = 0;i < n;++i) {
            sum += nums[i];
            int x = sum - k;
            if(map.containsKey(x)) {
                ret += map.get(x);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        
        return ret;
    }
}