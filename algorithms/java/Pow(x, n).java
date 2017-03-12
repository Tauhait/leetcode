public class Solution {
    private double pow(double x, long n) {
        if(n == 0) return 1;
        if(n == 1) return x;
        
        if(n < 0) {
            double y =  pow(x, -n);
            return 1 / y;
        } else {
            double y = pow(x, n / 2);
            if(n % 2 == 1) return y * y * x;
            return y * y;
        }
    }
    
    public double myPow(double x, int n) {
        return pow(x, (long) n);
    }
}