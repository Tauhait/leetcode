public class Solution {
    public int countPrimes(int n) {
        if(n < 2) return 0;
        
        boolean[] prime = new boolean[n];
        Arrays.fill(prime, true);
        prime[0] = false;
        prime[1] = false;
        // one of the factor should be less than or equal to sqrt(n - 1)
        int end = (int) Math.sqrt(n - 1);
        for(int i = 2;i <= end;++i) {
            if(prime[i] == false) continue;
            for(int j = 2 * i;j < n;j += i) {
                prime[j] = false;
            }
        }
        
        int count = 0;
        for(int i = 0;i < n;++i) {
            if(prime[i]) {
                count++;
            }
        }
        return count;
    }
}