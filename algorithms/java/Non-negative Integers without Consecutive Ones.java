public class Solution {
    public int findIntegers(int num) {
		String num2 = Integer.toString(num, 2);
		int n = num2.length();
		
		// opt[i] is the number combinations without consective 1s and with total i 0s and 1s
		// it could starts with 0
		int[] opt = new int[32];
	    opt[0] = 1; // the rest has no bits, but the previous bits fix a number
		opt[1] = 2;
		opt[2] = 3;
		for(int i = 3;i < 32;++i) {
		    // end with 0 and
		    // end with 01
		    opt[i] = opt[i - 1] + opt[i - 2];
		}

        int ret = 0;
        for(int i = 0;i < n;++i) {
            if(num2.charAt(i) == '1') {
                //set i-th bit to be 0
                ret += opt[n - i - 1];
                if(i != 0 && num2.charAt(i - 1) == '1') {
                    ret--;
                    // the number itself is not valid
                    break;
                } 
            }  
        }
        
        // add the number itself
        return ret + 1;
	}
}