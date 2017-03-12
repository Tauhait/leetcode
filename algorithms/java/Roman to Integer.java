public class Solution {
    public int romanToInt(String s) {
        //I, II, III, IV, V, VI, VII, VIII, IX, X
        //int[] Int = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        //String[] Char = new String[]{"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "VI", "I"};
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        map.put("M", 1000);
        map.put("CM", 900);
        map.put("D", 500);
        map.put("CD", 400);
        map.put("C", 100);
        map.put("XC", 90);
        map.put("L", 50); 
        map.put("XL", 40);
        map.put("X", 10);  
        map.put("IX", 9);
        map.put("V", 5);    
        map.put("IV", 4);
        map.put("I", 1); 
        
        int res = 0;
        for(int i = 0;i < s.length();++i) {
            if(i + 1 < s.length() && map.get(s.substring(i, i + 1)) < map.get(s.substring(i + 1, i + 2))) {
                res += map.get(s.substring(i + 1, i + 2)) - map.get(s.substring(i, i + 1));
                i++;
            } else {
                res += map.get(s.substring(i, i + 1));
            }
        }
        
        return res;
    }
}