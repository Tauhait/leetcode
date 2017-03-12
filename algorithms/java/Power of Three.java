public class Solution {
    public boolean isPowerOfThree(int n) {
        if(n == 0) return false;
        if(n == 1) return true;
       
   
        
        int m = (int) (Math.log(n) / Math.log(3));
        long r1 = (long) Math.pow(3, m);
        long r2 = (long) Math.pow(3, m + 1);
        long r3 = (long) Math.pow(3, m - 1);
        System.out.println(r1 + " " + r2 + " " + r3);
        if(r1 == n || r2 == n || r3 == n) return true;
        return false;
    }
}