public class Solution {
    private void reverse(int[] citations) {
        int i = 0, j = citations.length - 1;
        while(i < j) {
            int t = citations[i];
            citations[i] = citations[j];
            citations[j] = t;
            i++;
            j--;
        }
    }
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        reverse(citations);
        for(int i = 1;i <= citations.length;++i) {
            if(citations[i - 1] >= i) {
                continue;
            } else {
                return i - 1;
            }
        }
        return citations.length;
    }
}


public class Solution {
    public int hIndex(int[] citations) {
        int maxCitation = 0;
        for(int i = 0;i < citations.length;++i) {
            maxCitation = Math.max(citations[i], maxCitation);
        }
        int n = Math.min(maxCitation, citations.length);
        if(n == 0) {
            return 0;
        }
        int[] count = new int[n + 1];
        for(int i = 0;i < citations.length;++i) {
            if(citations[i] >= n) {
                count[n]++;
            } else {
                count[citations[i]]++;
            }
        }
        int s = 0;
        for(int i = n;i >= 0;--i) {
            s += count[i];
            if(s >= i) {
                return i;
            }
        }
        return 0;
    }
}