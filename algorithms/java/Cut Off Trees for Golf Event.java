class Solution {
    private static final int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    
    private class TreePos implements Comparable<TreePos> {
        int r;
        int c;
        int height;
        
        public TreePos(int r, int c, int height) {
            this.r = r;
            this.c = c;
            this.height = height;
        }
        
        public int compareTo(TreePos that) {
            return height - that.height;
        } 
    }
    
    private int m;
    private int n;
    
    private int[][] matrix;
    PriorityQueue<TreePos> trees = new PriorityQueue<>();

    int getStep(int[] curPos, int[] den) {
        boolean[][] v = new boolean[m][n];
        
        if(curPos[0] == den[0] && curPos[1] == den[1]) return 0;
        Queue<int[]> q = new LinkedList<>();
        v[curPos[0]][curPos[1]] = true; 
        q.add(curPos);
        int lev = 0;
        while(!q.isEmpty()) {
            int s = q.size();
            lev++;
            for(int i = 0;i < s;++i) {
                int[] pos = q.poll();
                for(int d = 0;d < 4;++d) {
                    int r = pos[0] + dir[d][0];
                    int c = pos[1] + dir[d][1];
                    if(r >= 0 && r < m && c >= 0 && c < n && v[r][c] == false && matrix[r][c] != 0) {
                        if(r == den[0] && c == den[1]) return lev;
                        v[r][c] = true;
                        q.add(new int[]{r, c});
                    }
                }
            }
        }
        return -1;
    }
    
    public int cutOffTree(List<List<Integer>> forest) {
        m = forest.size();
        if(m == 0) return 0;
        n = forest.get(0).size();
        if(n == 0) return 0;
        matrix = new int[m][n];
        for(int i = 0;i < m;++i) {
            for(int j = 0;j < n;++j) {
                matrix[i][j] = forest.get(i).get(j);
                if(matrix[i][j] > 1) {
                    trees.add(new TreePos(i, j, matrix[i][j]));
                }
            }
        }
        
        int steps = 0;
        int[] curPos = new int[]{0, 0};
        while(!trees.isEmpty()) {
            TreePos pos = trees.poll();
            int s = getStep(curPos, new int[]{pos.r, pos.c});
            if(s < 0) return -1;
            steps += s;
            curPos = new int[]{pos.r, pos.c};
            matrix[pos.r][pos.c] = 1;
        }
        return trees.isEmpty() ? steps : -1; 
    }
}