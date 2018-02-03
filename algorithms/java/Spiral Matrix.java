class Solution {
    private static final int[][] DIR = new int[][]
    {
        {0, 1},    // right 
        {1, 0},    // down
        {0, -1},   // left
        {-1, 0}    // up
    };
    
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = m == 0 ? 0 : matrix[0].length;
        if(m == 0 || n == 0) return Collections.emptyList();
        int numOfElements = m * n;
        
        int minR = 0, maxR = m - 1;
        int minC = 0, maxC = n - 1;
        int d = 0, r= 0, c = 0;
        List<Integer> arr = new ArrayList<>();
        arr.add(matrix[r][c]);
        while(arr.size() < numOfElements) {
            int nr = r + DIR[d][0];
            int nc = c + DIR[d][1];
            if(nr > maxR || nr < minR || nc > maxC || nc < minC) {
                if(d == 0) minR++;
                if(d == 1) maxC--;
                if(d == 2) maxR--;
                if(d == 3) minC++;
                d = (d + 1) % 4;
            } else{
                arr.add(matrix[nr][nc]);
                r = nr;
                c = nc;
            }
        }
        return arr;
    }
}