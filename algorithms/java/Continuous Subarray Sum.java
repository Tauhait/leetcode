public class Solution {   
    public boolean checkSubarraySum(int[] nums, int k) {
        if(nums.length < 2) {
            return false;
        }
        
        int[] sum = new int[nums.length];
        sum[0] = nums[0];
        for(int i = 1;i < nums.length;++i) {
            sum[i] = sum[i - 1] + nums[i];
        }
  
        HashMap<Integer, List<Integer> > map = new HashMap<>();
        map.put(0, new ArrayList<>());
        map.get(0).add(-1);
        for(int i = 0;i < nums.length;++i) {
            if(k == 0) {
                map.putIfAbsent(sum[i], new ArrayList<>());
                map.get(sum[i]).add(i);
            } else {
                map.putIfAbsent(sum[i] % k, new ArrayList<>());
                map.get(sum[i] % k).add(i);  
            }
        }
        
        for(Map.Entry<Integer, List<Integer> > entry: map.entrySet()) {
            List<Integer> value = entry.getValue();
            if(value.size() >= 2 && value.get(value.size() - 1) > value.get(0) + 1) {
                return true;
            }   
        }
        return false;        
    }
}