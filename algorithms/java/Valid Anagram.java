public class Solution {
    private String sortString(String s) {
        char[] str = s.toCharArray();
        Arrays.sort(str);
        return new String(str);
    }
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        String sortS = sortString(s);
        String sortT = sortString(t);
        if(sortS.equals(sortT)) return true;
        return false;
    }
}