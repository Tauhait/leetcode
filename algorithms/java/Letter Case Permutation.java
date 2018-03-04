class Solution {
    private void dfs(int d, String S, char[] cur, List<String> ans) {
        if(d == S.length()) {
            ans.add(new String(cur));
            return;
        }
        
        if(Character.isLetter(S.charAt(d))) {
            char c = Character.toLowerCase(S.charAt(d));
            cur[d] = c;
            dfs(d + 1, S, cur, ans);
            cur[d] = Character.toUpperCase(c);
            dfs(d + 1, S, cur, ans);
        } else {
            cur[d] = S.charAt(d);
            dfs(d + 1, S, cur, ans);
        }
    }
    
    public List<String> letterCasePermutation(String S) {
        List<String> ans = new ArrayList<>();
        dfs(0, S, new char[S.length()], ans);
        return ans;
    }
}