class Solution {
    public int newInteger(int n) {
        if(n <= 0) throw new IllegalArgumentException();
        
        StringBuilder sb = new StringBuilder();
        while(n != 0) {
            sb.append(n % 9);
            n /= 9;
        }
        return Integer.parseInt(sb.reverse().toString());
    }
}