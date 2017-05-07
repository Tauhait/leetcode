public class Solution {
    int[] count = new int[26];
    HashMap<Character, Integer> map = new HashMap<>();
    public boolean checkInclusion(String s1, String s2) {
        Arrays.fill(count, 0);
        for(char c: s1.toCharArray()) {
            count[c - 'a']++;
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int notZeros = 0;
        for(int i = 0;i < 26;++i) {
            if(count[i] != 0) {
                notZeros++;
            }
        }
        int start = 0;
        int end = 0;
        int numOfZero = 0;
        while(end < s2.length()) {
            char c = s2.charAt(end);
            if(map.containsKey(c) == false) {
                while(start < end) {
                    count[s2.charAt(start) - 'a']++;
                    start++;
                }
                start++;
                end++;
                numOfZero = 0;
                continue;
            }
            
            count[c - 'a']--;
            if(count[c - 'a'] < 0) {
                while(start < end) {
                    count[s2.charAt(start) - 'a']++;
                    if(count[s2.charAt(start) - 'a'] == 1) {
                        numOfZero--;    
                    }
                    start++;
                    if(count[c - 'a'] == 0) {
                        break;
                    }
                }
            } else if(count[c - 'a'] == 0) {
                numOfZero++;
                if(numOfZero == notZeros) {
                    return true;
                }
            } 
            end++;
        }
        
        return false;
    }
}