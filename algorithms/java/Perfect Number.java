public class Solution {
    public boolean checkPerfectNumber(int num) {
        if(num <= 1) {
            return false;
        }
        
        int n = (int) Math.sqrt(num);
        int sum = 1;
        for(int i = 2;i <= n;++i) {
            if(num % i == 0) {
                sum += i;
                sum += num / i;
            }
        }
        
        if(sum == num) {
            return true;
        } else {
            return false;
        }
    }
}