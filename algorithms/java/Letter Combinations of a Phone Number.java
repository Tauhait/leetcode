public class Solution {
    private static final Map<Character, String> map = new HashMap<>();
    static {
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
    }
    
    private List<String> ret = new ArrayList<>();
    
    private void dfs(int n, int d, String digits, char[] c) {
        if(n == d) {
            ret.add(String.valueOf(c));
            return ;
        }    
        char digit = digits.charAt(d);
        if(!map.containsKey(digit)) {
            throw new IllegalArgumentException();
        }
        
        String letters = map.get(digit);
        for(char letter: letters.toCharArray()) {
            c[d] = letter;
            dfs(n, d + 1, digits, c);
        }
    }
    
    public List<String> letterCombinations(String digits) {
        if(digits.length() == 0) {
            return ret;
        }
        char[] c = new char[digits.length()];
        dfs(digits.length(), 0, digits, c);
        return ret;
    }
}