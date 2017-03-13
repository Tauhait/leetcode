public class Solution {
    public int strStr(String haystack, String needle) {
        for(int i = 0;i <= haystack.length() - needle.length();++i) {
            boolean yes = true;
            for(int j = 0;j < needle.length();++j) {
                if(needle.charAt(j) != haystack.charAt(i + j)) {yes = false; break;}
            }
            if(yes) return i;
        }
        
        return -1;
    }
}