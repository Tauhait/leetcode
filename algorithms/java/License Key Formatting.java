class Solution {
    public String licenseKeyFormatting(String S, int K) {
        String s = S.replace('-', '').toUpperCase();
        if(s.isEmpty()) return "";
        int firstLength = s.length() % K;
        StringBuilder sb = new StringBuilder();
        
        if(firstLength != 0) 
            sb.append(s.substring(0, firstLength));
        
        int start = firstLength;
        while(start < s.length()) {
            if(sb.length() != 0) sb.append('-');
            sb.append(s.substring(start, K + start));
            start = K + start;
        }
        return sb.toString();
    }
}