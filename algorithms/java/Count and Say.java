public class Solution {
    String say(String str) {
        if(str == null || str.length() == 0) return "";
        
        StringBuilder res = new StringBuilder();
        int count = 1;
        char chr = str.charAt(0);
        for(int i = 1;i < str.length();++i) {
            if(str.charAt(i) != chr) {
                res.append(count).append(chr);
               
                
                count = 1;
                chr = str.charAt(i);
            } else {
                count++;
            }
        }
        
        if(count != 0) {
            res.append(String.valueOf(count));
            res.append(chr);
        }
        
        return res.toString();
    }
    
    public String countAndSay(int n) {
        String res = String.valueOf(1);
        for(int i = 1;i < n;++i) {
            res = say(res);
        }
        
        return res;
    }
}