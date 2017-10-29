/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    char[] buffer = new char[4];
    int buffer_size = 0;
    int s = 0;

    public int read(char[] buf, int n) {
        int k = 0;
        while(k < n) {
            while(s < buffer_size && k < n) {
                buf[k++] = buffer[s++];
            }
            
            if(s == buffer_size) {
                buffer_size = read4(buffer);
                s = 0;
                if(buffer_size == 0) break;
            }
        }

        return k;
    }
}
/////////////////////
/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    char[] cbuf = new char[4];
    int cbufIndex = 0;
    int cbufSize = -1;
    
    public int read(char[] buf, int n) {
        int index = 0;
        while(index < n) {
            while(cbufIndex < cbufSize && index < n) buf[index++] = cbuf[cbufIndex++];
            if(cbufIndex >= cbufSize && index < n) {
                if(cbufSize < 4 && cbufSize != -1) return index;
                cbufSize = read4(cbuf);
                cbufIndex = 0;
            }
        }
        return index;
    }
}

////////////////////////
/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    private char[] buffer = new char[4];
    private int numChar = 0;
    private int readIndex = 0;
    
    public int read(char[] buf, int n) {
        int index = 0;
        while(index < n) {
            while(readIndex < numChar && index < n) buf[index++] = buffer[readIndex++];
            if(index < n) {
                numChar = read4(buffer);
                readIndex = 0;
                if(numChar == 0) break;
            }
        }
        return index;
    }
}