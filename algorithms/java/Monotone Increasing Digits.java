class Solution {
    public int monotoneIncreasingDigits(int N) {
        if(N < 10) return N;
        
        String num = String.valueOf(N);
        char[] chr = num.toCharArray();
        int len = chr.length;
        for(int i = len - 2;i >= 0;--i) {
            if(chr[i] > chr[i + 1]) {
                chr[i] = (char) (((int) chr[i]) - 1);
                for(int j = i + 1;j < len;++j) chr[j] = '9';
            }
        }
        String newNum = String.valueOf(chr);
        int index = 0;
        while(index < newNum.length() && newNum.charAt(index) == '0') index++;
        if(index == newNum.length()) return 0;
        return Integer.parseInt(newNum.substring(index));
    }
}