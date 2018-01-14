class Solution {
    private boolean isPrime(int num) {
        if(num < 2) return false;
        if(num == 2) return true;
        for(int i = 2;i <= (int) Math.sqrt(num);++i) {
            if(num % i == 0) return false;
        }
        return true;
    }
    
    private int numOfOnes(int num) {
        int n = 0;
        while(num != 0) {
            num = num & (num - 1);
            n++;
        }
        return n;  
    }
    
    public int countPrimeSetBits(int L, int R) {
        int ret = 0;
        for(int i = L;i <= R;++i) {
            ret += isPrime(numOfOnes(i)) ? 1 : 0;
        }
        return ret;
    }
}