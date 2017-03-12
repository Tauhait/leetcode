public class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int start = 0;
        int res = 0;
       
        for(int i = 0;i < s.length();++i) {
            char c = s.charAt(i);
            if(map.containsKey(c) && map.get(c) >= start) {
                res = Math.max(res, i - start);
                start = map.get(c) + 1;
            }
            map.put(c, i);
        }
        
        res = Math.max(res, s.length() - start);

        return res;
    }
}