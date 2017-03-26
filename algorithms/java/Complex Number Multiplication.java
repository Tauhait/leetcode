public class Solution {
    private class ComplexNumber {
        int a;
        int b;
        public ComplexNumber(int _a, int _b) {
            a = _a;
            b = _b;
        }
    }
    private ComplexNumber getab(String num) {
        int index = num.indexOf('+');
        String real = num.substring(0, index);
        String virtual = num.substring(index + 1, num.length() - 1);
      
        
        int a = Integer.valueOf(real);
        int b = Integer.valueOf(virtual);
        return new ComplexNumber(a, b);
    }
    
    public String complexNumberMultiply(String a, String b) {
        ComplexNumber ca = getab(a);
        ComplexNumber cb = getab(b);
        int na = ca.a * cb.a - ca.b * cb.b;
        int nb = ca.a * cb.b + ca.b * cb.a;
        
        StringBuilder sb = new StringBuilder();
        sb.append(String.valueOf(na));
        sb.append('+');
        sb.append(String.valueOf(nb));
        sb.append('i');
        
        return sb.toString();
    }
}