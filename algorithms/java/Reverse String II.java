public class Solution {
    public String reverseStr(String s, int k) {
        if(k <= 1) return s;
        if(s.length() <= 1) return s;
        StringBuilder res = new StringBuilder();
        int i = 0;
        while(true) {
            int start = i * k;
            int end = (i + 1) * k;
            if(end > s.length()) end = s.length();
            String t = s.substring(start, end);
            String rev_t = new StringBuilder(t).reverse().toString();
            res.append(rev_t);
            if(end == s.length()) break;
            
            
            i = i + 1;
            start = i * k;
            end = (i + 1) * k;
            if(end > s.length()) end = s.length();
            res.append(s.substring(start, end));
            if(end == s.length()) break;
            
            i = i + 1;
        }
        
        return res.toString();
    }
}