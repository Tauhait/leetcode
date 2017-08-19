public class Solution {
    public int[] findDiagonalOrder(int[][] matrix) {
        int m = matrix.length;
        if(m == 0) return new int[0];
        int n = matrix[0].length;
        if(n == 0) return new int[0];
        
        int[] arr = new int[m * n];
        int index = 0;
        for(int s = 0;s < m + n - 1;++s) {
            if(s % 2 == 0) {
                int r = s;
                int c = 0;
                if(r >= m) {r = m - 1;c = s - m + 1;}
                while(r >= 0 && c <= n - 1) {
                    arr[index++] = matrix[r][c];r--;c++;
                }
            } else {
                int r = 0;
                int c = s;
                if(c >= n) {r = s - n + 1;c = n - 1;}
                while(r <= m - 1 && c >= 0) {
                    arr[index++] = matrix[r][c];r++;c--;
                }
            }
        }
        return arr;
    }
}