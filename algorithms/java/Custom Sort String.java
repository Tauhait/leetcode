class Solution {
    public String customSortString(String S, String T) {
        int[] count = new int[26];
        for(int i = 0;i < T.length();++i) {
            count[(int)(T.charAt(i) - 'a')]++;
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i < S.length();++i) {
            int index = (int)(S.charAt(i) - 'a');
            while(count[index] > 0) {
                sb.append(S.charAt(i));
                count[index]--;
            }
        }
        for(int i = 0;i < 26;++i) {
            while(count[i] > 0) {
                sb.append((char)(i + 'a'));
                count[i]--;
            }
        }
        return sb.toString();
    }
}