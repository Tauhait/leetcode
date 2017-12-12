public class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if(k == 0) return 0;
        HashMap<Character, Integer> count = new HashMap<>();
        int num_distinct = 0;
        int start = 0;
        int end = 0;
        int res = 0;
        while(end < s.length()) {
            char c = s.charAt(end);
            if(!count.containsKey(c)) {
                num_distinct++;
                count.put(c, 1);
            } else if(count.get(c) == 0) {
                num_distinct++;
                count.put(c, 1);
            } else {
                count.put(c, count.get(c) + 1);
            }
            
            while(num_distinct > k) {
                char cc = s.charAt(start);
                count.put(cc, count.get(cc) - 1);
                start++;
                if(count.get(cc) == 0) {
                    num_distinct--;
                }
            }
            if(num_distinct <= k) {
                res = Math.max(res, end - start + 1);
            }
            end++;
        }
        
        
        return res;
    }
}

////////////////////////
class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if(k <= 0) return 0;
        
        Map<Character, Integer> count = new HashMap<>();
        int start = 0, distinct = 0, longest = 0;
        for(int i = 0;i < s.length();++i) {
            char c = s.charAt(i);
            count.put(c, count.getOrDefault(c, 0) + 1);
            if(count.get(c) == 1) distinct++;
            
            if(distinct <= k && i - start + 1 > longest) longest = i - start + 1;
            
            while(distinct > k && start <= i) {
                count.put(s.charAt(start), count.get(s.charAt(start)) - 1);
                if(count.get(s.charAt(start)) == 0) distinct--;
                start++;
            }
        }
        return longest;
    }
}