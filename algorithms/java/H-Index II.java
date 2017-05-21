public class Solution {
    public int hIndex(int[] citations) {
        int index = 0;
        for(int i = citations.length - 1;i >= 0;--i) {
            if(citations[i] >= index + 1) {
                index++;
                continue;
            } else {
                return index;
            }
        }
        
        return citations.length;
    }
}

public class Solution {
    public int hIndex(int[] citations) {
        int l = 0, r = citations.length;
        while(l < r) {
            int m = l + (r - l + 1) / 2;
            if(citations[citations.length - m] >= m) {
                l = m;
            } else {
                r = m - 1;
            }
        }
        
        return l;
    }
}