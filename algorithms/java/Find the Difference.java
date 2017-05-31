public class Solution {
    public char findTheDifference(String s, String t) {
        Map<Character, Integer> mapS = new HashMap<>();
        Map<Character, Integer> mapT = new HashMap<>();
        
        for(char c: s.toCharArray()) {
            mapS.put(c, mapS.getOrDefault(c, 0) + 1);
        }
        for(char c: t.toCharArray()) {
            if(!mapS.containsKey(c)) {
                return c;
            }
            mapT.put(c, mapT.getOrDefault(c, 0) + 1);
        }
        
        for(Map.Entry<Character, Integer> entry: mapS.entrySet()) {
            if(entry.getValue() + 1 == mapT.get(entry.getKey())) {
                return entry.getKey();
            }
        }
        
        return '-';
    }
}