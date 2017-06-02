public class Solution {
    public int longestConsecutive(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0;i < nums.length;++i) {
            map.put(nums[i], i);
        }
        
        int[] opt = new int[nums.length];
        Arrays.fill(opt, 0);
        for(int i = 0;i < nums.length;++i) {
            if(opt[i] != 0) {
                continue;
            }
            int j = nums[i];
            int count = 1;
            while(map.containsKey(j - 1)) {
                count++;
                j--;
            }
            
            j = i;
            while(true) {
                opt[j] = count;
                count--;
                if(count == 0) break;
                j = map.get(nums[j] - 1);
            }
        }
        
        int maxLen = 0;
        for(int i = 0;i < nums.length;++i) {
            maxLen = Math.max(opt[i], maxLen);
        }
        return maxLen;
    }
}



public class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int i = 0;i < nums.length;++i) {
            set.add(nums[i]);
        }
        
        int maxLen = 0;
        for(int i = 0;i < nums.length;++i) {
            if(!set.contains(nums[i] - 1)) {
                int count = 0;
                int j = nums[i];
                while(set.contains(j)) {
                    count++;
                    j++;
                }
                maxLen = Math.max(maxLen, count);
            }
        }

        return maxLen;
    }
}


// Line 3: java.lang.StackOverflowError
public class Solution {
    private int longestConsecutiveEnd(int num, int[] opt, Map<Integer, Integer> map) {
        if(!map.containsKey(num)) {
            return 0;
        }
        int id = map.get(num);
        if(opt[id] != -1) {
            return opt[id];
        }
        
        int ret = longestConsecutiveEnd(num - 1, opt, map) + 1;
        opt[id] = ret;
        return ret;
    }
    
    public int longestConsecutive(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0;i < nums.length;++i) {
            map.put(nums[i], i);
        }
        
        int[] opt = new int[nums.length];
        Arrays.fill(opt, -1);
        
        for(int i = 0;i < nums.length;++i) {
            longestConsecutiveEnd(nums[i], opt, map);    
        }
        
        int maxLen = 0;
        for(int i = 0;i < nums.length;++i) {
            maxLen = Math.max(opt[i], maxLen);
        }
        return maxLen;
    }
}