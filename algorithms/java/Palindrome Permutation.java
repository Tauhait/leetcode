public class Solution {
    HashMap<Character, Integer> count = new HashMap<>();
    
    public boolean canPermutePalindrome(String s) {
        for(int i = 0;i < s.length();i++) {
            if(count.containsKey(s.charAt(i))) {
                count.put(s.charAt(i), count.get(s.charAt(i)) + 1);
            } else {
                count.put(s.charAt(i), 1);
            }
        }    
        
        int odd_count = 0;
        for(Integer val : count.values()) {
            if(val % 2 == 1) odd_count++;
        }
        
        if(odd_count > 1) return false;
        return true;
    }
}