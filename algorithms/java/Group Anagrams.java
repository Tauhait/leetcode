public class Solution {
    private String sortString(String s) {
        char[] str = s.toCharArray();
        Arrays.sort(str);
        return new String(str);
    }
    
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String> > map = new HashMap<>();
        for(int i = 0;i < strs.length;++i) {
            String s = sortString(strs[i]);
            if(!map.containsKey(s)) {
                map.put(s, new ArrayList<>());   
            }
            map.get(s).add(strs[i]);
        }
        List<List<String> > res = new ArrayList<>();
        for(Map.Entry<String, List<String> > entry: map.entrySet()) {
            res.add(entry.getValue());
        }
        return res;
    }
}