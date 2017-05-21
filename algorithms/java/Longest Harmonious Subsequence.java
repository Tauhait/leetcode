public class Solution {
    public int findLHS(int[] nums) {
        int n = nums.length;
        if(n == 0) {
            return 0;
        }
        
        Arrays.sort(nums);
        ArrayList<Integer> list = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        
        int cur = nums[0];
        list.add(cur);
        map.put(nums[0], map.getOrDefault(nums[0], 0) + 1);
        for(int i = 1;i < n;++i) {
            if(nums[i] != cur) {
                cur = nums[i];
                list.add(cur);
            }
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        
        int ans = 0;
        for(int i = 1;i < list.size();++i) {
            int a = list.get(i);
            int b = list.get(i - 1);
            if( a == b + 1) {
                ans = Math.max(ans, map.get(a) + map.get(b));
            }
        }
        
        return ans;
    }
}