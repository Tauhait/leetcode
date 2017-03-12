public class Solution {
    public String multiply(String num1, String num2) {
        int[] a = new int[num1.length()];
        int[] b = new int[num2.length()];
        
        for(int i = num1.length() - 1;i >= 0;--i) {
            a[num1.length() - i - 1] = num1.charAt(i) - '0'; // Character.getNumericValue
        }
       
        for(int i = num2.length() - 1;i >= 0;--i) {
            b[num2.length() - i - 1] = num2.charAt(i) - '0';
        }
        for(int i = 0;i < a.length;++i) {
            System.out.println(a[i]);
        }
        System.out.println();
        for(int i = 0;i < b.length;++i) {
            System.out.println(b[i]);
        }
        System.out.println();
        
        int[] res = new int[a.length + b.length];
        for(int i = 0;i < a.length;++i) {
            for(int j = 0;j < b.length;++j) {
                res[i + j] += a[i] * b[j];
            }
        }
        
        int c = 0;
        for(int i = 0;i < res.length;++i) {
            int s = res[i] + c;
            res[i] = s % 10;
            c = s / 10;
        }
        
        int l = a.length + b.length;
        while(l > 0 && res[l - 1] == 0) {
            l--;
        }
        if(l == 0) {
            return new String("0");
        }
        System.out.println("l = " + l);
        StringBuffer str = new StringBuffer();
        for(int i = l - 1;i >= 0;--i) {
            System.out.print(res[i]);
            str.append(res[i]);
        }
        System.out.println();
        return str.toString();
    }
}