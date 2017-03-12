public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        if(m == 0) return false;
        int n = matrix[0].length;
        if(n == 0) return false;
        
        int l = 0, r = m * n - 1;
        while(l <= r) {
            int mid = l + (r - l) / 2;
            
            int row = mid / n;
            int col = mid % n;
            if(matrix[row][col] == target) return true;
            else if(matrix[row][col] > target) r = mid - 1;
            else l = mid + 1;
        }
        return false;
    }
}