class Solution {
    private void adjustSize(TreeMap<Integer, Integer> small, TreeMap<Integer, Integer> large,
                            int[] size, int k) {
        int offset = k % 2;
        while(size[0] > size[1] + offset) {
            size[0]--;
            size[1]++;
            int num = small.lastKey();
            small.put(num, small.get(num) - 1);
            if(small.get(num) == 0) small.remove(num);
            large.put(num, large.getOrDefault(num, 0) + 1);
        }
        while(size[0] < size[1] + offset) {
            size[0]++;
            size[1]--;
            int num = large.firstKey();
            large.put(num, large.get(num) - 1);
            if(large.get(num) == 0) large.remove(num);
            small.put(num, small.getOrDefault(num, 0) + 1);
        }
    }
    
    double getMedian(TreeMap<Integer, Integer> small, TreeMap<Integer, Integer> large,
                     int[] size, int k) {
        adjustSize(small, large, size, k);
        System.out.println(size[0] + " " + size[1]);
        if(k % 2 == 1) {
            return (double) small.lastKey();    
        } else {
            return ((double) small.lastKey() + (double) large.firstKey()) / 2.0;
        }
    }
    
    public double[] medianSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        if(n < k) return new double[0];
        
        TreeMap<Integer, Integer> small = new TreeMap<>();
        TreeMap<Integer, Integer> large = new TreeMap<>();
        int[] size = new int[2];
        for(int i = 0;i < k;++i) {
            small.put(nums[i], small.getOrDefault(nums[i], 0) + 1);
            size[0]++;
        }
        double[] median = new double[n - k + 1];
        for(int i = k;i < n;++i) {
            median[i - k] = getMedian(small, large, size, k);
            if(small.containsKey(nums[i - k]) && small.get(nums[i - k]) > 0) {
                small.put(nums[i - k], small.get(nums[i - k]) - 1);
                if(small.get(nums[i - k]) == 0) small.remove(nums[i - k]);
                size[0]--;
                large.put(nums[i], large.getOrDefault(nums[i], 0) + 1);
                size[1]++;
            } else if(large.containsKey(nums[i - k]) && large.get(nums[i - k]) > 0) {
                large.put(nums[i - k], large.get(nums[i - k]) - 1);
                if(large.get(nums[i - k]) == 0) large.remove(nums[i - k]);
                size[1]--;
                small.put(nums[i], small.getOrDefault(nums[i], 0) + 1);
                size[0]++;
            } 
        }
        median[n - k] = getMedian(small, large, size, k);
        return median;        
    }
}