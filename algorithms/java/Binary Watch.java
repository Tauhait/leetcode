public class Solution {
    private int numOfOneBits(int num) {
        int c = 0;
        for(int i = 0;i < 10;++i) {
            if((num & (1 << i)) != 0) {
                c++;
            }
        }
        return c;
    }
    
    public List<String> readBinaryWatch(int n) {
        List<String> ret = new ArrayList<>();
        for(int i = 0;i < (1 << 10);++i) {
            if(numOfOneBits(i) == n) {
                int hour = i >>> 6;
                int minute = i & ((1 << 6) - 1);
                if(hour > 11) {
                    continue;
                }
                if(minute >= 60) {
                    continue;
                }
                String min = String.valueOf(minute);
                if(min.length() < 2) {
                    min = "0" + min;
                }
                ret.add(String.valueOf(hour) + ":" + min);
            }
        }
        return ret;
    }
}