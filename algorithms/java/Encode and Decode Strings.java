public class Codec {
    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i < strs.size();++i) {
            sb.append(strs.get(i).length());
            sb.append(",");
            sb.append(strs.get(i));
        }
        
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> decodeStrings = new ArrayList<>();
        int start = 0;
        int pos = s.indexOf(",", start);
        while(pos >= 0) {
            int len = Integer.parseInt(s.substring(start, pos));
            decodeStrings.add(s.substring(pos + 1, pos + len + 1));
            
            start = pos + len + 1;
            pos = s.indexOf(",", start);
        }
        
        return decodeStrings;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));