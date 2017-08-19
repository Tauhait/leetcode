public class Solution {
    public boolean judgeCircle(String moves) {
        Map<Character, Integer> map = new HashMap<>();
        for(char c: moves.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int u = map.getOrDefault('U', 0);
        int d = map.getOrDefault('D', 0);
        int r = map.getOrDefault('R', 0);
        int l = map.getOrDefault('L', 0);
        if(u == d && r == l) return true;
        return false;        
    }
}