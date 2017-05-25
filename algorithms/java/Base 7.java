public class Solution {
    public String convertToBase7(int num) {
        if(num == 0) {
            return "0";
        }
        int sign = Integer.signum(num);
        int n = Math.abs(num);
        
        ArrayList<Integer> arr = new ArrayList<>();
        while(n != 0) {
            arr.add(n % 7);
            n /= 7;
        }
        
        StringBuilder sb = new StringBuilder();
        if(sign == -1) {
            sb.append("-");
        }
        for(int i = arr.size() - 1;i >= 0;--i) {
            sb.append((char)(arr.get(i) + '0'));
        }
        
        return sb.toString();
    }
}