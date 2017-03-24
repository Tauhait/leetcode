public class Solution {
    private void dfs(int d, int n, Integer[] cur, boolean[] used, int[] nums, List<List<Integer> > res) {
        if(d == n) {
            ArrayList<Integer> ans = new ArrayList<>();
            for(int i = 0;i < n;++i) {
                ans.add(cur[i]);
            }
            res.add(ans); // here should be Integer[], if it is int[], we cannot use asList
            return ;
        }
        
        for(int i = 0;i < n;++i) {
            if(used[i] == false) {
                cur[d] = nums[i];
                used[i] = true;
                dfs(d + 1, n, cur, used, nums, res);
                used[i] = false;
            }
        }
    }
    
    
    public List<List<Integer> > permute(int[] nums) {
        List<List<Integer> > res = new ArrayList<>();
        int n = nums.length;
        if(n == 0) {
            return res;
        }
        Integer[] cur = new Integer[n];
        boolean[] used = new boolean[n];
        Arrays.fill(used, false);
        dfs(0, n, cur, used, nums, res);
        
        return res;
    }
}