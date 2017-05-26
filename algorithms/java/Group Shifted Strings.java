public class Solution {
    private String shiftStartsWithA(String str) {
        if(str.length() == 0) {
            return "";
        }
        if(str.charAt(0) == 'a') {
            return str;
        }
        int d = (int)(str.charAt(0) - 'a');
        StringBuilder sb = new StringBuilder();
        sb.append('a');
        for(int i = 1;i < str.length();++i) {
            int c = (int)(str.charAt(i) - d);
            if(c < (int)('a')) {
                c += 26;
            }
            sb.append((char)(c));
        }
        return sb.toString();
    }
    public List<List<String>> groupStrings(String[] strings) {
        HashMap<String, List<String> > map = new HashMap<>();
        for(int i = 0;i < strings.length;++i) {
            String key = shiftStartsWithA(strings[i]);
            if(!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(strings[i]);
        }
        
        return new ArrayList<>(map.values());
    }
}