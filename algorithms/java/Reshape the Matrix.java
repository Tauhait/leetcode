public class Solution {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int m = nums.length;
        if(m == 0) {
            return nums;
        }
        int n = nums[0].length;
        if(n == 0) {
            return nums;
        }
        
        if(m * n != r * c) {
            return nums;
        }
        
        int[][] matrix = new int[r][c];
        int nr = 0;
        int nc = 0;
        for(int i = 0;i < m;++i) {
            for(int j = 0;j < n;++j) {
                matrix[nr][nc] = nums[i][j];
                nc++;
                if(nc == c) {
                    nc = 0;
                    nr++;
                }
            }
        }
        
        return matrix;
    }
}