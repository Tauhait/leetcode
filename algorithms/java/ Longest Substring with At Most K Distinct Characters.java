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