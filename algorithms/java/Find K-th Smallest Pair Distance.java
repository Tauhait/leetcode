// PriorityQueue Time Limit Exceeded
class Solution {
    private static class Pair {
        int dis;
        int i;
        int j;
        
        public Pair(int dis, int i, int j) {
            this.dis = dis;
            this.i = i;
            this.j = j;
        }
    }
    
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        int n = nums.length;
        for(int i = 1;i < n;++i)
            pq.add(new int[]{nums[i] - nums[i - 1], i - 1, i});
        
        while(k > 0) {
            k--;
            int[] front = pq.poll();
            if(k == 0) return front[0];
            int i = front[1];
            int j = front[2];
            if(j + 1 < n) pq.add(new int[]{nums[j + 1] - nums[i], i, j + 1});
        }
        return -1;      
    }
}

//////// Binary Search
class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int min = Integer.MAX_VALUE;
        for(int i = 1;i < n;++i) min = Math.min(min, nums[i] - nums[i - 1]);
        int max = nums[n - 1] - nums[0];
        
        int L = min, R = max;
        while(L < R) {
            int mid = L + (R - L) / 2;
            int numLess = 0;
            for(int i = 0;i < n - 1;++i) numLess += binarySearch(nums, n, i, mid);
            if(numLess < k) L = mid + 1;
            else R = mid;
        }
        return L;
    }
    
    private int binarySearch(int[] nums, int n, int i, int b) {
        // number of distance in row i is n - i - 1
        int L = 0, R = n - i - 1; 
        while(L < R) {
            int m = L + (R - L) / 2;
            if(nums[i + m + 1] - nums[i] <= b) L = m + 1;
            else R = m;
        }
        return L;
    }
}