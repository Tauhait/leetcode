// O(n^2)
public class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        int n = envelopes.length;
        if(n == 0) {
            return 0;
        }
        Arrays.sort(envelopes, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
       
        int[] opt = new int[n];
        Arrays.fill(opt, 1);
        for(int i  = 0;i < n;++i) {
            for(int j = 0;j < i;++j) {
                if(envelopes[i][0] > envelopes[j][0] && envelopes[i][1] > envelopes[j][1]) {
                    opt[i] = Math.max(opt[i], 1 + opt[j]);
                }
            }
        }
        int ret = 0;
        for(int i = 0;i < n;++i) {
            ret = Math.max(ret, opt[i]);
        }
        return ret;
    }
}

// O(nlogn)
public class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        int n = envelopes.length;
        if(n == 0) {
            return 0;
        }
        Arrays.sort(envelopes, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
       
        ArrayList<Integer> lis = new ArrayList<>();
        for(int i = 0;i < n;++i) {
            int pos = Collections.binarySearch(lis, envelopes[i][1]);
            if(pos < 0) {
                int insertPos = -(pos + 1);
                if(insertPos == lis.size()) {
                    lis.add(envelopes[i][1]);
                } else {
                    lis.set(insertPos, envelopes[i][1]);
                }
            }
        }
        return lis.size();
    }
}