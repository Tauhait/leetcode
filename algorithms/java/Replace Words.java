public class Solution {
    private class Comp implements Comparator<String> {
        public int compare(String a, String b) {
            if(a.length() == b.length()) return a.compareTo(b);
            return a.length() - b.length();
        }
    }
    
    public String replaceWords(List<String> dict, String sentence) {
        Collections.sort(dict, new Comp());
        String[] s = sentence.split("\\s+");
        if(s.length == 0) return "";
        for(int i = 0;i < s.length;++i) {
            for(int j = 0;j < dict.size();++j) {
                if(s[i].startsWith(dict.get(j))) {
                    s[i] = dict.get(j);
                    break;
                }
            }
        }
        
        StringBuilder sb = new StringBuilder();
        sb.append(s[0]);
        for(int i = 1;i < s.length;++i) {
            sb.append(" ");
            sb.append(s[i]);
        }
        return sb.toString();
    }
}