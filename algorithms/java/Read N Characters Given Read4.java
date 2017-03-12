/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    public int read(char[] buf, int n) {
        int k = 0;
        while(k < n) {
            char[] buffer = new char[4];
            int s = read4(buffer);
            for(int i = 0;i < s && k < n;++i) {
                buf[k++] = buffer[i];
            }
            if(s < 4) break;
        }

        return k;
    }
}