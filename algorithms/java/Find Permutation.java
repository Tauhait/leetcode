public class Solution {
    public int[] findPermutation(String s) {
        int n = s.length();
        int[] ret = new int[n + 1];
       
        int start = 1;
        int index = 0;
        int i = 0;
        while(i < n) {
            if(s.charAt(i) == 'I') {
                ret[index++] = start++;
                i++;
            } else {
                int c = 0;
                while(i < n && s.charAt(i) =='D') {
                    c++;
                    i++;
                }
                
                for(int k = start + c;k >= start;--k) {
                    ret[index++] = k;
                }
                start = start + c + 1;
                i++;
            }
        }
        
        while(index < n + 1) {
            ret[index++] = start++;
        }
        
        return ret;
    }
}