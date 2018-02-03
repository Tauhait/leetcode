public class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        int[] res = new int[n];
        int c = 1;
        for(int i = n - 1;i >= 0;--i) {
            int s = c + digits[i];
            res[i] = s % 10;
            c = s / 10;
        }
        if(c == 0) {
            return res;
        } else {
            int[] ress = new int[n + 1];
            ress[0] = c;
            for(int i = 0;i < n;++i) {
                ress[i + 1] = res[i];
            }
            return ress;
        }
    }
}

class Solution {
    public int[] plusOne(int[] digits) {
        int carry = 1;
        List<Integer> plus = new ArrayList<>();
        for(int i = digits.length - 1;i >= 0;--i) {
            int s = digits[i] + carry;
            plus.add(s % 10);
            carry = s / 10;
        }
        if(carry != 0) plus.add(carry);
        
        Collections.reverse(plus);
        int[] sum = new int[plus.size()];
        for(int i = 0;i < plus.size();++i) {
            sum[i] = plus.get(i);
        }
        return sum;
    }
}