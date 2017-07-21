public class Solution {
    private int[] root;
    private char[][] land;
    private int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    
    private int getID(int r, int c, int m, int n) {
        return r * n + c;
    }
    
    private int findRoot(int id) {
        int tid = id;
        while(root[tid] != tid) {
            tid = root[tid];
        }
        
        // update
        while(root[id] != tid) {
            int xid = root[id];
            root[id] = tid;
            id = xid;
        }
        
        return tid;
    }
    
    private int findRoot(int r, int c, int m, int n) {
        return findRoot(getID(r, c, m, n));
    }
    
    private void union(int r1, int c1, int r2, int c2, int m, int n) {
        int id1 = getID(r1, c1, m, n);
        int id2 = getID(r2, c2, m, n);
        int root1 = findRoot(id1);
        int root2 = findRoot(id2);
        if(root1 == root2) {
            return ;
        }
        
        root[root1] = root2;
    }
    
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        root = new int[m * n];
        land = new char[m][n];
        
        for(int i = 0;i < m * n;++i) {
            root[i] = i;
        }
        
        for(int i = 0;i < m;++i) {
            Arrays.fill(land[i], '0');
        }
        
        int numOfIsland = 0;
        List<Integer> ret = new ArrayList<>();
        for(int i = 0;i < positions.length;++i) {
            int r = positions[i][0];
            int c = positions[i][1];
            if(land[r][c] == '1') {
                ret.add(numOfIsland);
                continue;
            }
            
            land[r][c] = '1';
            numOfIsland++;
            
            for(int d = 0;d < 4;++d) {
                int nr = r + dir[d][0];
                int nc = c + dir[d][1];
                if(nr >= 0 && nr < m && nc >= 0 && nc < n && land[nr][nc] == '1') {
                    int root = findRoot(nr, nc, m, n);
                    int rootrc = findRoot(r, c, m, n);
                    if(root != rootrc) {
                        union(r, c, nr, nc, m, n);
                        numOfIsland--;
                    }
                }
            }
            ret.add(numOfIsland);
        }
        
        return ret;
    }
}