public class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<>();
        while(true) {
            if(set.contains(n)) return false;
            String nStr = String.valueOf(n);
            int sum = 0;
            for(int i = 0;i < nStr.length();++i) {
                sum += (nStr.charAt(i) - '0') * (nStr.charAt(i) - '0');
            }
            if(sum == 1) return true;
            set.add(n);
            n = sum;
        }
    }
}