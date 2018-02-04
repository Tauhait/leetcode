class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> s1 = new HashSet<>();
        Set<Integer> s2 = new HashSet<>();
        for(int i = 0;i < nums1.length;++i) s1.add(nums1[i]);
        for(int i = 0;i < nums2.length;++i) s2.add(nums2[i]);
        Set<Integer> inter = new HashSet<>();
        for(Integer num: s1) {
            if(s2.contains(num)) inter.add(num);
        }
        int[] res = new int[inter.size()];
        int index = 0;
        for(Integer num: inter) {
            res[index++] = num;
        }
        return res;
    }
}