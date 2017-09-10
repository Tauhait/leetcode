class Solution {
    private void swap(char[] c, int i, int j) {
        char t = c[i];
        c[i] = c[j];
        c[j] = t;
    }
    
    private void reverse(char[] c, int i, int j) {
        while(i < j) {
            swap(c, i, j);
            i++;
            j--;
        }
    }
    
    public int nextGreaterElement(int n) {
        if(n == Integer.MAX_VALUE) return -1;
        
        String s = String.valueOf(n);
        if(s.length() == 1) return -1;
        
        int index = -1;
        for(int i = s.length() - 1;i > 0;--i) {
            if(s.charAt(i) > s.charAt(i - 1)) {
                index = i - 1; 
                break;
            }    
        }
        if(index == -1) return -1;
        
        int index2 = -1;
        for(int i = s.length() - 1;i >= 0;--i) {
            if(s.charAt(i) > s.charAt(index)) {
                index2 = i;
                break;
            }
        }
        char[] c = s.toCharArray();
        swap(c, index, index2);
        reverse(c, index + 1, c.length - 1);
        
        String ss = new String(c);
        long r = Long.parseLong(ss);       
        if(r > Integer.MAX_VALUE) return -1;
        return Math.toIntExact(r);
    }
}