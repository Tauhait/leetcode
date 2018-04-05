class Solution {
    public int[] numberOfLines(int[] widths, String S) {
        int line = 0;
        int count = 0;
        for(int i = 0;i < S.length();++i) {
            if(count + widths[S.charAt(i) - 'a'] > 100) {
                line++;
                count = widths[S.charAt(i) - 'a'];
            } else {
                count += widths[S.charAt(i) - 'a'];
            }
        }
        return new int[]{line + 1, count};  
    }
}