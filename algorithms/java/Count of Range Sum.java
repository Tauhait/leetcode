public class Solution {
    public int countRangeSum(int[] nums, int lower, int upper) {
        int n = nums.length;
        if(n == 0) {
            return 0;
        }
        TreeMap<Long, Integer> map = new TreeMap<>();
        map.put(0L, 1);
        int ret = 0;
        long s = 0;
        for(int i = 0;i < n;++i) {
            s += nums[i];
            long l = -upper + s;
            long r = -lower + s;
            Map<Long, Integer> subMap = map.subMap(l, true, r, true);
            for(Map.Entry<Long, Integer> entry: subMap.entrySet()) {
                ret += entry.getValue();
            } 
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        return ret;
    }
}