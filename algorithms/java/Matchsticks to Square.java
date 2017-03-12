public class Solution {
    int[] f;
    int len;
    boolean found;
    private void dfs(int d, int cur, int[] nums) {
        if(found == true) return ;
        for(int i = 0;i < nums.length;++i) {
            if(found == true) return ;
            if(f[i] == 1) continue;
            
            if(cur + nums[i] > len) continue;
            
            if(cur + nums[i] == len) {
                if(d == 3) {
                    found = true;
                    return;
                }
                
                f[i] = 1;
                dfs(d + 1, 0, nums);
                f[i] = 0;
            } else {
                f[i] = 1;
                dfs(d, cur + nums[i], nums);
                f[i] = 0;
            }
            
            while(i + 1 < nums.length && nums[i + 1] == nums[i]) i++;
        }
    }
    
    public boolean makesquare(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        for(int i = 0;i < nums.length;++i) {
            sum += nums[i];
        }
        
        if(sum % 4 != 0) return false;
        
        len = sum / 4;
        
        if(len == 0) return false;
        
        f = new int[nums.length];
        Arrays.fill(f, 0);
        found = false;
        dfs(0, 0, nums);
        return found;
    }
}