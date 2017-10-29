class Solution {
    private int compress(char[] chars, int i, int index, int count) {
        String num = String.valueOf(count);
        if(1 + num.length() <= count) {
            chars[index++] = chars[i - 1];
            for(char c: num.toCharArray()) chars[index++] = c;
        } else {
            for(int j = 0;j < count;++j)
                chars[index++] = chars[i - 1];
        }
        return index;
    }

    public int compress(char[] chars) {
        int n = chars.length;
        if(n == 0 || n == 1) return n;
        int index = 0, count = 1;
        for(int i = 1;i < n;++i) {
            if(chars[i] == chars[i - 1]) count++;
            else {
                index = compress(chars, i, index, count);
                count = 1;
            }
        }
        index = compress(chars, n, index, count);
        
        return Math.min(n, index);
    }
}