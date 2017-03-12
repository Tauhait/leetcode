public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        if(m == 0) return false;
        int n = matrix[0].length;
        if(n == 0) return false;
        
        int r = m - 1;
        int c = 0;
        
        while(r >= 0 && c < n) {
            if(matrix[r][c] == target) return true;
            else if(matrix[r][c] > target) r--;
            else if(matrix[r][c] < target) c++;
        }
        return false;
    }
}