public class Solution {
    public int longestSubstring(String s, int k) {
        if(s.length() < k) return 0;
        int[] count = new int[26];
        Arrays.fill(count, 0);
        for(int i = 0;i < s.length();++i) {
            count[(int)(s.charAt(i) - 'a')]++;
        }
        char c = '-';
        for(int i = 0;i < 26;++i) {
            if(count[i] < k && count[i] != 0) {
                c = (char) (i + 'a');
                break;
            }
        }
        if(c == '-') return s.length();
        
        int index = -1;
        for(int i = 0;i < s.length();++i) {
            if(s.charAt(i) == c) {
                index = i;
                break;
            }
        }
        
        String left = s.substring(0, index);
        String right = s.substring(index + 1, s.length());
        int l = 0;
        int r = 0;
        if(index >= k) {
            l = longestSubstring(s.substring(0, index), k);
        }
        if(s.length() - index - 1 >= k) {
            r = longestSubstring(s.substring(index + 1, s.length()), k);
        }
        if(l > r) return l;
        return r;
    }
}