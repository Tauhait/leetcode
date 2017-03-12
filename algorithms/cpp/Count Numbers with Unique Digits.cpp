class Solution {
public:
    int A(int n, int m) {
        int s = 1;
        for(int i = 0;i < m;++i) {
            s *= n;
            n--;
        }
        return s;
    }
    
    int countNumbersWithUniqueDigits(int n) {
        if(n == 0) return 1;
        if(n == 1) return 10;
        if(n > 10) n = 10;
        int sum = 10;
        for(int i = 2;i <= n;++i) {
            sum += 9 * A(9, i - 1);
        }
        return sum;
    }
};