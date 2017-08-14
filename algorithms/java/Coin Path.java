public class Solution {
    public List<Integer> cheapestJump(int[] A, int B) {
        int n = A.length;
        List<Integer> ret = new ArrayList<>();
        if (n == 0 || A[n - 1] < 0) return ret;
        int[] opt = new int[n];
        Arrays.fill(opt, -1);
        opt[n - 1] = A[n - 1];
        
        int[] next = new int[n];
        Arrays.fill(next, -1);
        
        for (int i = n - 2; i >= 0; --i) {
            if (A[i] == -1) {
                opt[i] = -1;
                continue;
            }

            // smaller first
            for (int j = i + 1; j < n && j - i <= B; ++j) {
                if (opt[j] == -1) continue;
                if (opt[i] == -1) {
                    opt[i] = opt[j] + A[i];
                    next[i] = j;
                } else {
                    if (opt[j] + A[i] < opt[i]) {
                        opt[i] = opt[j] + A[i];
                        next[i] = j;
                    }
                }
            }
        }
        
        if(opt[0] == -1) return ret;
        
        ret.add(1);
        int index = 0;
        while(index != n - 1) {
            ret.add(next[index] + 1);
            index = next[index];
        }
        return ret;
    }
}
